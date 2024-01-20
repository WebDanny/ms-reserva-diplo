package com.nur.command.person.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import com.nur.util.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPersonHandler implements Command.Handler<GetPersonQuery, PersonDTO>{

    private final IPersonRepository personRepository;

    public GetPersonHandler(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDTO handle(GetPersonQuery getPersonCommand) {
        Personas person = personRepository.getById(UUID.fromString(getPersonCommand.personId));
        if(person == null){
            return null;
        }
        return PersonMapper.from(person);
    }
}
