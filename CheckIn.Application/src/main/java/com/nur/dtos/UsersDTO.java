package com.nur.dtos;

import com.nur.annotations.Generated;

@Generated
public class UsersDTO {
    public String id;
    public String userName;
    public String email;
    public String secretPass;
    public String accountType;
    public String personId;

    public UsersDTO() {
    }

    public UsersDTO(String id, String userName, String email, String secretPass, String accountType, String personId) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.secretPass = secretPass;
        this.accountType = accountType;
        this.personId = personId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretPass() {
        return secretPass;
    }

    public void setSecretPass(String secretPass) {
        this.secretPass = secretPass;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
