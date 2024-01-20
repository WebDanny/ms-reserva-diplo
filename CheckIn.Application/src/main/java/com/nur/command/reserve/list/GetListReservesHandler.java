package com.nur.command.reserve.list;

import an.awesome.pipelinr.Command;
import com.nur.command.person.list.GetListPersonsQuery;
import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Personas;
import com.nur.model.Reserve;
import com.nur.repositories.IPersonRepository;
import com.nur.repositories.IReserveRepository;
import com.nur.util.PersonMapper;
import com.nur.util.ReserveMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListReservesHandler implements Command.Handler<GetListReservesQuery, List<ReserveDTO>> {

    private final IReserveRepository reserveRepository;

    public GetListReservesHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @Override
    public List<ReserveDTO> handle(GetListReservesQuery command) {
        try {
            List<Reserve> reserves = this.reserveRepository.getAll();
            return reserves.stream().map(ReserveMapper::from).toList();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}