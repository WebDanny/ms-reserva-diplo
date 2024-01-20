package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.UserJpaModel;
import com.nur.model.Usuario;

public class UsersUtils {
    public static UserJpaModel userToJpaEntity(Usuario users){
        UserJpaModel model = new UserJpaModel();
        model.setId(users.getId());
        model.setUsername(users.getUsername());
        model.setEmail(users.getEmail());
        model.setPassword(users.getPass());
        model.setAccountType(users.getAccountType());
        model.setPersonId(users.getPersonId());
        return model;
    }

    public static Usuario jpaToUser(UserJpaModel jpaModel) throws BusinessRuleValidationException {
        return new Usuario(
                jpaModel.getUsername(),
                jpaModel.getEmail(),
                jpaModel.getPassword(),
                jpaModel.getAccountType(),
                jpaModel.getPersonId()
        );
    }
}
