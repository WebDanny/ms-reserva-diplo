package com.nur.command.commend.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendDTO;
import com.nur.model.Commend;
import com.nur.repositories.ICommendRepository;
import com.nur.util.CommendMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCommendHandler implements Command.Handler<GetCommendQuery, CommendDTO> {

    private final ICommendRepository commendRepository;

    public GetCommendHandler(ICommendRepository commendRepository) {
        this.commendRepository = commendRepository;
    }

    @Override
    public CommendDTO handle(GetCommendQuery command) {
        Commend commend = commendRepository.getById(UUID.fromString(command.commendId));
        if(commend == null) return null;
        return CommendMapper.from(commend);
    }
}
