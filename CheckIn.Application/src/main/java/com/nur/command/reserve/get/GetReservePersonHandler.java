package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Reserve;
import com.nur.repositories.IReserveRepository;
import com.nur.util.ReserveMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetReservePersonHandler implements Command.Handler<GetReservePersonQuery, List<ReserveDTO>>{

    private final IReserveRepository reserveRepository;

    public GetReservePersonHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }


    @Override
    public List<ReserveDTO> handle(GetReservePersonQuery command) {
        List<Reserve> reserve = new ArrayList<>();
        try {
            reserve = reserveRepository.getByPersonId(command.personId);
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }

        return ReserveMapper.fromReserveToDTO(reserve);
    }
}