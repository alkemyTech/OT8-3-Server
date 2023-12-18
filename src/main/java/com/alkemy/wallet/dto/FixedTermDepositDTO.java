package com.alkemy.wallet.dto;


import java.util.Date;

public class FixedTermDepositDTO {
    private Double amount;
    private Double interest;
    private Date creationDate;
    private Date closingDate;

    public FixedTermDepositDTO(Double amount, Double interest, Date creationDate, Date closingDate) {
        this.amount = amount;
        this.interest = interest;
        this.creationDate = creationDate;
        this.closingDate = closingDate;
    }

    public FixedTermDepositDTO() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

}
