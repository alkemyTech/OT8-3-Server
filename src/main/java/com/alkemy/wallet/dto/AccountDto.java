package com.alkemy.wallet.dto;

import com.alkemy.wallet.enums.Currency;
import com.alkemy.wallet.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.alkemy.wallet.model.Account}
 */
@Value
public class AccountDto implements Serializable {
    Currency currency;
    @NotNull
    Double transactionLimit;
    @NotNull
    Double balance;
    User user;
}