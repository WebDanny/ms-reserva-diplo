package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Reserve;
import com.nur.repositories.IReserveRepository;
import com.nur.util.ReserveMapper;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class GetReserveHandler implements Command.Handler<GetReserveQuery, ReserveDTO> {

  private final IReserveRepository reserveRepository;

  public GetReserveHandler(IReserveRepository reserveRepository) {
    this.reserveRepository = reserveRepository;
  }

  @Override
  public ReserveDTO handle(GetReserveQuery getReserveCommand) {
    Reserve reserve = reserveRepository.getById(UUID.fromString(getReserveCommand.reserveId));
    if (reserve == null) {
      return null;
    }
    return ReserveMapper.from(reserve);
  }
}
