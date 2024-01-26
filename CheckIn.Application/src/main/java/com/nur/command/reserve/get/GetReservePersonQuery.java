package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;

import java.util.List;

public class GetReservePersonQuery implements Command<List<ReserveDTO>> {
    String personId;

    public GetReservePersonQuery(String personId) {
        this.personId = personId;
    }


}