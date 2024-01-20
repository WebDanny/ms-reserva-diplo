package com.nur.command.person.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import com.nur.util.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListPersonsHandler implements Command.Handler<GetListPersonsQuery, List<PersonDTO>> {

    private final IPersonRepository personRepository;

    public GetListPersonsHandler(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> handle(GetListPersonsQuery command) {
        try {
            List<Personas> personas = this.personRepository.getAll();
            return personas.stream().map(PersonMapper::from).toList();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
