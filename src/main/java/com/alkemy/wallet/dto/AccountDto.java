package com.alkemy.wallet.dto;

import com.alkemy.wallet.enums.Currency;
import com.alkemy.wallet.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.alkemy.wallet.model.Account}
 */
@Data
@Value
public class AccountDto implements Serializable {
    private Currency currency;
    @NotNull
    private Double transactionLimit;
    @NotNull
    private Double balance;

    private User user;
}