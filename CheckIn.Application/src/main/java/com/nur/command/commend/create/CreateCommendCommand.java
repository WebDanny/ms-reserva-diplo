package com.nur.command.commend.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendDTO;

public class CreateCommendCommand implements Command<CommendDTO> {
    CommendDTO commendDTO;

    public CreateCommendCommand(CommendDTO commendDTO) {
        this.commendDTO = commendDTO;
    }
}
