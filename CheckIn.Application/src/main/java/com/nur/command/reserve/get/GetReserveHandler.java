package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.command.person.get.GetPersonQuery;
import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Personas;
import com.nur.model.Reserve;
import com.nur.repositories.IPersonRepository;
import com.nur.repositories.IReserveRepository;
import com.nur.util.PersonMapper;
import com.nur.util.ReserveMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetReserveHandler implements Command.Handler<GetReserveQuery, ReserveDTO>{

    private final IReserveRepository reserveRepository;

    public GetReserveHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @Override
    public ReserveDTO handle(GetReserveQuery getReserveCommand) {
        Reserve reserve = reserveRepository.getById(UUID.fromString(getReserveCommand.reserveId));
        if(reserve == null){
            return null;
        }
        return ReserveMapper.from(reserve);
    }
}