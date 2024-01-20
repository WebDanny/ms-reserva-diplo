package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.users.create.CreateUserCommand;
import com.nur.command.users.get.GetUserQuery;
import com.nur.command.users.list.GetListUserQuery;
import com.nur.dtos.UsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController("/api/users")
public class UserControllers {
    Logger logger = LoggerFactory.getLogger(PersonsController.class);

    final Pipeline pipeline;

    public UserControllers(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/create")
    public UsersDTO createUser(@RequestBody UsersDTO usersDTO){
        CreateUserCommand command = new CreateUserCommand(usersDTO);
        return command.execute(pipeline);
    }

    @GetMapping("/get-user/{userId}")
    public UsersDTO getById(@PathVariable UUID userId){
        GetUserQuery query = new GetUserQuery(userId);
        return query.execute(pipeline);
    }

    @GetMapping("/get-all-users")
    public List<UsersDTO> getAllUsers(){
        GetListUserQuery query = new GetListUserQuery();
        return query.execute(pipeline);
    }
}
