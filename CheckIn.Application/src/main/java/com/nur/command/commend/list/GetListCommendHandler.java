package com.nur.command.commend.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendDTO;
import com.nur.model.Commend;
import com.nur.repositories.ICommendRepository;
import com.nur.util.CommendMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListCommendHandler implements Command.Handler<GetListCommendQuery, List<CommendDTO>> {

    private final ICommendRepository commendRepository;

    public GetListCommendHandler(ICommendRepository commendRepository) {
        this.commendRepository = commendRepository;
    }

    @Override
    public List<CommendDTO> handle(GetListCommendQuery command) {
        try {
            List<Commend> commends = this.commendRepository.getAll();
            return commends.stream().map(CommendMapper::from).toList();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
