package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;

public class GetReserveQuery implements Command<ReserveDTO> {
    String reserveId;

    public GetReserveQuery(String reserveId) {
        this.reserveId = reserveId;
    }
}