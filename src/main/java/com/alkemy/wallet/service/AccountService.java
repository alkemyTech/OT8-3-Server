package com.alkemy.wallet.service;
import com.alkemy.wallet.dto.*;
import com.alkemy.wallet.enums.CurrencyEnum;
import com.alkemy.wallet.enums.TypeEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.FixedTermDeposit;
import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.FixedTermDepositRepository;
import com.alkemy.wallet.repository.TransactionsRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;



@Service
public class AccountService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;
    private TransactionsRepository transactionsRepository;
    private FixedTermDepositRepository fixedTermDepositRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository, UserRepository userRepository, TransactionsRepository transactionsRepository,FixedTermDepositRepository fixedTermDepositRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transactionsRepository = transactionsRepository;
        this.fixedTermDepositRepository = fixedTermDepositRepository;
    }

    public List<Account> getAccountsByUserId(Long id){

        return accountRepository.getAccountsByUserId(id);
    }

    public AccountResponseDTO createAccount (AccountRequestDTO accountRequestDTO){
        Double transactionLimit = accountRequestDTO.getCurrency().toUpperCase().equals("ARS") ? 300000.0 : 1000.0;
        User user =  userRepository.findById(Long.decode(accountRequestDTO.getUserAuthenticated())).orElseThrow(()-> new IllegalStateException("User not found"));

        Account account = new Account(
                user,
                CurrencyEnum.valueOf(accountRequestDTO.getCurrency().toUpperCase()),
                transactionLimit
        );
        Account savedAccount = accountRepository.save(account);
        AccountResponseDTO response = new AccountResponseDTO();
        response.setCurrency(savedAccount.getCurrencyEnum().name());
        response.setBalance(savedAccount.getBalance());
        response.setUserId(user.getId().toString());
        response.setTransactionLimit(savedAccount.getTransactionLimit());
        return response;
    }

    public AccountUpdateResponseDTO updateAccount (AccountUpdateDTO accountUpdateDTO, String userAuthEmail, String accountId){
        User userAuth = userRepository.findByEmail(userAuthEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Account account = accountRepository.getAccountsByUserId(userAuth.getId())
                .stream()
                .filter(a -> a.getId().equals(Long.decode(accountId)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no se encontro algo"));

        if(account.getUser() != null && account.getId() != null) {
                account.setTransactionLimit(accountUpdateDTO.getTransactionLimit());
                Account accountNewLimit = accountRepository.save(account);
                AccountUpdateResponseDTO accountUpdateResponse = new AccountUpdateResponseDTO();
                accountUpdateResponse.setNewTransactionLimit(accountNewLimit.getTransactionLimit());
                return accountUpdateResponse;
            } else {throw new IllegalStateException("no anda nada");}
        }



        public BalanceResponseDTO getBalance(String userAuthEmail){
            User userAuth = userRepository.findByEmail(userAuthEmail)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            List<Account> accountAuth = accountRepository.getAccountsByUserId(userAuth.getId());
            List<Transactions> userAuthTransactions = transactionsRepository.findByAccountIdIn(accountAuth
                    .stream()
                    .map(Account::getId)
                    .toList());

            List<Transactions> userAuthTransactionsArs = userAuthTransactions
                    .stream()
                    .filter(transactions -> transactions.getAccount().getCurrencyEnum().equals(CurrencyEnum.ARS))
                    .toList();
            List<Transactions> userAuthTransactionsUsd = userAuthTransactions
                    .stream()
                    .filter(transactions -> transactions.getAccount().getCurrencyEnum().equals(CurrencyEnum.USD))
                    .toList();


            Double incomeArs = userAuthTransactionsArs
                    .stream()
                    .filter(transactions -> transactions.getTypeEnum().equals(TypeEnum.INCOME))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum).orElseThrow(()-> new IllegalStateException("no hay transacciones INCOME"));
            Double paymentArs = userAuthTransactionsArs
                    .stream()
                    .filter(transactions -> transactions.getTypeEnum().equals(TypeEnum.PAYMENT))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum).orElseThrow(()-> new IllegalStateException("no hay transacciones PAYMENT"));

            Double incomeUsd = userAuthTransactionsUsd
                    .stream()
                    .filter(transactions -> transactions.getTypeEnum().equals(TypeEnum.INCOME))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum).orElseThrow(()-> new IllegalStateException("no hay transacciones INCOME"));
            Double paymentUsd = userAuthTransactionsUsd
                    .stream()
                    .filter(transactions -> transactions.getTypeEnum().equals(TypeEnum.PAYMENT))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum).orElseThrow(()-> new IllegalStateException("no hay transacciones PAYMENT"));

            List<FixedTermDeposit> fixedTerm = fixedTermDepositRepository.findByAccountIn(accountAuth);
            List<FixedTermDepositResponseDto> fixedTermDepositDTOs = fixedTerm.stream().map(ft ->{
                return new FixedTermDepositResponseDto(
                        ft.getAmount(),
                        new Timestamp(ft.getCreationDate().getTime()),
                        ft.getClosingDate(),
                        ft.getInterest(),
                        null
                );
            }).toList();

            List<TransactionDTO> transactionDTO = userAuthTransactions.stream().map(transactions -> {
              return new TransactionDTO(
                        transactions.getAmount(),
                        transactions.getTypeEnum().name(),
                        transactions.getDescription(),
                        transactions.getTransactionDate());
                    }).toList();
            return new BalanceResponseDTO(
                    incomeArs - paymentArs,
                    incomeUsd - paymentUsd,
                    transactionDTO,
                    fixedTermDepositDTOs
            ){};
        }
    }

