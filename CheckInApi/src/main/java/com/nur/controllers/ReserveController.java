package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.person.create.CreatePersonCommand;
import com.nur.command.person.get.GetPersonQuery;
import com.nur.command.person.list.GetListPersonsQuery;
import com.nur.command.reserve.create.CreateReserveCommand;
import com.nur.command.reserve.get.GetReserveQuery;
import com.nur.command.reserve.list.GetListReservesQuery;
import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReserveController {
    Logger logger = LoggerFactory.getLogger(ReserveController.class);

    final Pipeline pipeline;

    public ReserveController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/reserve/create")
    public ReserveDTO createReserve(@RequestBody ReserveDTO reserve){
        CreateReserveCommand command = new CreateReserveCommand(reserve);
        return command.execute(pipeline);
    }

    @GetMapping("/reserve/{reserveId}")
    public ReserveDTO findById(@PathVariable String reserveId){
        GetReserveQuery query = new GetReserveQuery(reserveId);
        return query.execute(pipeline);
    }

    @GetMapping("/reserves")
    public List<ReserveDTO> getAll(){
        GetListReservesQuery query = new GetListReservesQuery();
        return query.execute(pipeline);
    }
}
