package com.nur.command.users.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.UsersDTO;

import java.util.UUID;

public class GetUserQuery implements Command<UsersDTO> {
    UUID userId;

    public GetUserQuery(UUID userId) {
        this.userId = userId;
    }
}
