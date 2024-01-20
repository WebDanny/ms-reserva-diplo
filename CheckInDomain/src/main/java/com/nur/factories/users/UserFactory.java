package com.nur.factories.users;


import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Usuario;

import java.util.UUID;

public class UserFactory implements IUserFactory{
    @Override
    public Usuario createUser(String username, String email,  String password, String accountType, UUID personId) throws BusinessRuleValidationException {
        return new Usuario(username, email, password, accountType, personId);
    }
}
