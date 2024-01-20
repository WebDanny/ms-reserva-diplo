package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.commend.create.CreateCommendCommand;
import com.nur.command.commend.get.GetCommendQuery;
import com.nur.command.commend.list.GetListCommendQuery;
import com.nur.dtos.CommendDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommendController {
    Logger logger = LoggerFactory.getLogger(PersonsController.class);

    final Pipeline pipeline;

    public CommendController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/commend/create")
    public CommendDTO createCommend(@RequestBody CommendDTO commend){
        CreateCommendCommand command = new CreateCommendCommand(commend);
        return command.execute(pipeline);
    }

    @GetMapping("/commend/{commendId}")
    public CommendDTO findById(@PathVariable String commendId){
        GetCommendQuery query = new GetCommendQuery(commendId);
        return query.execute(pipeline);
    }
    
    @GetMapping("/commends")
    public List<CommendDTO> getAll(){
        GetListCommendQuery query = new GetListCommendQuery();
        return query.execute(pipeline);
    }
}
