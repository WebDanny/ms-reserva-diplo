package com.nur.factories.users;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Usuario;

import java.util.UUID;

public interface IUserFactory {
    Usuario createUser(String username, String email, String accountType, String password, UUID personId) throws BusinessRuleValidationException;
}
