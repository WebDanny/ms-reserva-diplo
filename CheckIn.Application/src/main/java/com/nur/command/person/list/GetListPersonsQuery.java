package com.nur.command.person.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PersonDTO;

import java.util.List;

public class GetListPersonsQuery implements Command<List<PersonDTO>> {
    public GetListPersonsQuery() {
    }
}
