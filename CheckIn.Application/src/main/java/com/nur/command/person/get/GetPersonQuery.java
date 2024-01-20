package com.nur.command.person.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;

public class GetPersonQuery implements Command<PersonDTO> {
    String personId;

    public GetPersonQuery(String personId) {
        this.personId = personId;
    }
}
