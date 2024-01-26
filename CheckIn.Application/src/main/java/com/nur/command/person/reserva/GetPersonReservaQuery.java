package com.nur.command.person.reserva;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;

import java.util.List;

public class GetPersonReservaQuery implements Command<List<PersonDTO>> {
    String personId;

    public GetPersonReservaQuery(String personId) {
        this.personId = personId;
    }
}
