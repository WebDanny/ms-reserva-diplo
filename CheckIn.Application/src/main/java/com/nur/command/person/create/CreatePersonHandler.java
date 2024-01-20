package com.nur.command.person.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;
import com.nur.factories.persons.IPersonaFactory;
import com.nur.factories.persons.PersonaFactory;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import com.nur.util.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePersonHandler implements Command.Handler<CreatePersonCommand, PersonDTO> {

    private final IPersonRepository personRepository;

    private final IPersonaFactory personaFactory;

    public CreatePersonHandler(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        this.personaFactory = new PersonaFactory();
    }

    @Override
    public PersonDTO handle(CreatePersonCommand request) {
        Personas persona = null;
        try {
            persona = personaFactory.createPerson(request.personDTO.getName(), request.personDTO.getLastName(), request.personDTO.getCi());
            if(persona == null){
                return null;
            }
            personRepository.update(persona);
            return PersonMapper.from(persona);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
