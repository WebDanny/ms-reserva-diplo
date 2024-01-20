package com.nur.util;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.UsersDTO;
import com.nur.model.Usuario;

import java.util.UUID;

public class UserMapper {
    public static UsersDTO from(Usuario user){
        if(user == null) return new UsersDTO();
        return new UsersDTO(
                user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getPass(),
                user.getAccountType(),
                user.getPersonId().toString()
        );
    }

    public static Usuario from(UsersDTO user) throws BusinessRuleValidationException {
        return new Usuario(
                user.getUserName(),
                user.getEmail(),
                user.getSecretPass(),
                user.getAccountType(),
                UUID.fromString(user.getPersonId())
        );
    }
}
