package com.nur.command.users.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.UsersDTO;
import com.nur.model.Usuario;
import com.nur.repositories.IUserRepository;
import com.nur.util.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListUsersHandler implements Command.Handler<GetListUserQuery, List<UsersDTO>> {

    private final IUserRepository userRepository;

    public GetListUsersHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersDTO> handle(GetListUserQuery command) {
        try {
            List<Usuario> users = this.userRepository.getAll();
            return users.stream().map(UserMapper::from).toList();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
