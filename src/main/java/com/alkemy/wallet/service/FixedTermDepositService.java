package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.FixedTermDepositRequestDto;
import com.alkemy.wallet.dto.FixedTermDepositResponseDto;
import com.alkemy.wallet.enums.CurrencyEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.FixedTermDeposit;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.FixedTermDepositRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class FixedTermDepositService {
    private FixedTermDepositRepository fixedTermDepositRepository;
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public FixedTermDepositService(FixedTermDepositRepository fixedTermDepositRepository,
                                   UserRepository userRepository,
                                   AccountRepository accountRepository
    ) {
        this.fixedTermDepositRepository = fixedTermDepositRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public FixedTermDepositResponseDto simulateFixedTermDeposit(FixedTermDepositRequestDto fixedTermDepositRequestDto) {
        double amount = fixedTermDepositRequestDto.getAmount();
        int days = fixedTermDepositRequestDto.getDays();
        if(amount > 0.0 && days > 0){
            return calculateFixedTermDeposit(amount,days);
        }
        return null;
    }

    private FixedTermDepositResponseDto calculateFixedTermDeposit(Double amount, int days) {
        double interestRate = 0.002;
        double interestPerDay =  amount * interestRate;
        double totalInterest = interestPerDay * days;
        double totalValue = amount + totalInterest;
        Timestamp creationDate = new Timestamp(new Date().getTime());
        Timestamp closingDate = new Timestamp(new Date().getTime() + (long) days * 24 * 60 * 60 * 1000);
        return new FixedTermDepositResponseDto(
                amount,
                creationDate,
                closingDate,
                totalInterest,
                totalValue
        );
    }
    public FixedTermDepositResponseDto fixedTermDepositOK(FixedTermDepositRequestDto fixedTermDepositRequestDto, String userAuthEmail) {

        User userAuth = userRepository.findByEmail(userAuthEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Account account = accountRepository.getAccountsByUserId(userAuth.getId())
                .stream()
                .filter(a -> a.getCurrencyEnum().equals(CurrencyEnum.ARS))
                .toList()
                .get(0);

        double amount = fixedTermDepositRequestDto.getAmount();
        int days = fixedTermDepositRequestDto.getDays();
        double balance = account.getBalance();

        if (amount > 0.0 && days >= 30) {
            if (balance >= amount) {
                account.setBalance(balance - amount);
                double interestRate = 0.002;
                double interestPerDay = amount * interestRate;

                double totalInterest = interestPerDay * days;
                double totalValue = amount + totalInterest;

                Timestamp creationDate = new Timestamp(new Date().getTime());
                Timestamp closingDate = new Timestamp(new Date().getTime() + (long) days * 24 * 60 * 60 * 1000);

                accountRepository.save(account);
                FixedTermDeposit savedFixedTermDeposit = new FixedTermDeposit(
                        amount,
                        totalInterest,
                        creationDate,
                        closingDate,
                        account);

                fixedTermDepositRepository.save(savedFixedTermDeposit);

                FixedTermDepositResponseDto response = new FixedTermDepositResponseDto(
                        amount ,
                        creationDate,
                        closingDate,
                        totalInterest,
                        totalValue
                );

            return response;
            } else {
                throw new IllegalArgumentException("balance insufficient");
            }

        } else {
            throw new IllegalArgumentException("saldo insuficiente o cantidad de dias menor a 30 o  ");
        }


    }

}