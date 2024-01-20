package com.nur.command.reserve.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;

public class CreateReserveCommand implements Command<ReserveDTO> {
    ReserveDTO reserveDTO;
    public CreateReserveCommand(ReserveDTO reserveDTO){
        this.reserveDTO = reserveDTO;
    }
}
