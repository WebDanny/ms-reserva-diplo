package com.nur.command.users.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.UsersDTO;
import com.nur.factories.users.IUserFactory;
import com.nur.factories.users.UserFactory;
import com.nur.model.Usuario;
import com.nur.repositories.IUserRepository;
import com.nur.util.UserMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, UsersDTO> {

    private final IUserRepository userRepository;
    private final IUserFactory userFactory;

    public CreateUserHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.userFactory = new UserFactory();
    }

    @Override
    public UsersDTO handle(CreateUserCommand command) {
        Usuario user = null;
        try {
            user = userFactory.createUser(command.usersDTO.getUserName(), command.usersDTO.getEmail(), command.usersDTO.getSecretPass(), command.usersDTO.getAccountType(), UUID.fromString(command.usersDTO.getPersonId()));
            if(user == null) return null;
            userRepository.update(user);
            return UserMapper.from(user);
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
