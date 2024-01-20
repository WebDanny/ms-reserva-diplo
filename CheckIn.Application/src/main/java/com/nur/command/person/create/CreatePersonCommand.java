package com.nur.command.person.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;

public class CreatePersonCommand implements Command<PersonDTO> {
    PersonDTO personDTO;

    public CreatePersonCommand(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }
}
