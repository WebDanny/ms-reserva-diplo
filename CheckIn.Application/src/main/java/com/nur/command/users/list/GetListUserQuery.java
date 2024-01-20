package com.nur.command.users.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.UsersDTO;

import java.util.List;

public class GetListUserQuery implements Command<List<UsersDTO>> {
    public GetListUserQuery() {
    }
}
