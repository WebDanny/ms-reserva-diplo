package com.nur.command.users.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.UsersDTO;
import com.nur.model.Usuario;
import com.nur.repositories.IUserRepository;
import com.nur.util.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class GetUserHandler implements Command.Handler<GetUserQuery, UsersDTO>{

    private final IUserRepository userRepository;

    public GetUserHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UsersDTO handle(GetUserQuery command) {
        Usuario user = userRepository.getById(command.userId);
        if(user == null) return null;
        return UserMapper.from(user);
    }
}
