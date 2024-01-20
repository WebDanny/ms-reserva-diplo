package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.person.create.CreatePersonCommand;
import com.nur.command.person.get.GetPersonQuery;
import com.nur.command.person.list.GetListPersonsQuery;
import com.nur.dtos.PersonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PersonsController {
    Logger logger = LoggerFactory.getLogger(PersonsController.class);

    final Pipeline pipeline;

    public PersonsController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/person/create")
    public PersonDTO createPerson(@RequestBody PersonDTO person){
        CreatePersonCommand command = new CreatePersonCommand(person);
        return command.execute(pipeline);
    }

    @GetMapping("/person/{personId}")
    public PersonDTO findById(@PathVariable String personId){
        GetPersonQuery query = new GetPersonQuery(personId);
        return query.execute(pipeline);
    }

    @GetMapping("/persons")
    public List<PersonDTO> getAll(){
        GetListPersonsQuery query = new GetListPersonsQuery();
        return query.execute(pipeline);
    }
}
