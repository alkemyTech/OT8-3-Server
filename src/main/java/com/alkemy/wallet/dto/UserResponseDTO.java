package com.alkemy.wallet.dto;

import java.sql.Timestamp;

public class UserResponseDTO {
    private String email;
    private String firstName;
    private String lastName;
    private Timestamp updateDate;

    public UserResponseDTO(String email, String firstName, String lastName, Timestamp updateDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.updateDate = updateDate;
    }

    public UserResponseDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
