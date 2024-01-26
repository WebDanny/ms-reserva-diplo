package com.nur.command.person.reserva;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;
import com.nur.repositories.IPersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPersonReservaHandler implements Command.Handler<GetPersonReservaQuery, List<PersonDTO>>{

    private final IPersonRepository personRepository;

    public GetPersonReservaHandler(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> handle(GetPersonReservaQuery command) {
        return null;
    }

    /*@Override
    public List<PersonDTO> handle(GetPersonReservaQuery getPersonCommand) {
        List<Personas> person = personRepository.getById(UUID.fromString(getPersonCommand.personId));
        if(person == null){
            return null;
        }
        return PersonMapper.from(person);
    }*/
}
