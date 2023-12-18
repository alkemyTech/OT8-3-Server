package com.alkemy.wallet.dto;

import java.util.List;

public class BalanceResponseDTO {
    private Double accountArs;
    private Double accountUsd;
    private List<TransactionDTO> history;
    private List<FixedTermDepositResponseDto> fixedTermDeposit;

    public BalanceResponseDTO(Double accountArs, Double accountUsd, List<TransactionDTO> history, List<FixedTermDepositResponseDto> fixedTermDeposit) {
        this.accountArs = accountArs;
        this.accountUsd = accountUsd;
        this.history = history;
        this.fixedTermDeposit = fixedTermDeposit;
    }

    public Double getAccountArs() {
        return accountArs;
    }

    public void setAccountArs(Double accountArs) {
        this.accountArs = accountArs;
    }

    public Double getAccountUsd() {
        return accountUsd;
    }

    public void setAccountUsd(Double accountUsd) {
        this.accountUsd = accountUsd;
    }

    public List<TransactionDTO> getHistory() {
        return history;
    }

    public void setHistory(List<TransactionDTO> history) {
        this.history = history;
    }

    public List<FixedTermDepositResponseDto> getFixedTermDeposit() {
        return fixedTermDeposit;
    }

    public void setFixedTermDeposit(List<FixedTermDepositResponseDto> fixedTermDeposit) {
        this.fixedTermDeposit = fixedTermDeposit;
    }
}
