package com.nur.model;

import com.nur.core.AggregateRoot;
import com.nur.core.BusinessRuleValidationException;
import com.nur.valueObjects.EmailValueObject;
import com.nur.valueObjects.PasswordValueObject;

import java.util.UUID;

public class Usuario extends AggregateRoot {
    public String username;

    public String accountType;

    public EmailValueObject email;

    public PasswordValueObject pass;

    public UUID personId;

    public String getUsername() {
        return username;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getPass() {
        return pass.getValue();
    }

    public UUID getPersonId() {
        return personId;
    }

    public Usuario(String username, String email, String pass, String accountType, UUID personId) throws BusinessRuleValidationException {
        id = UUID.randomUUID();
        this.username = username;
        this.email = new EmailValueObject(email);
        this.pass = new PasswordValueObject(pass);
        this.accountType = accountType;
        this.personId = personId;
    }
}
