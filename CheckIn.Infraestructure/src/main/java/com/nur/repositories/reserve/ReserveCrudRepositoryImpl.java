package com.nur.repositories.reserve;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;
import com.nur.repositories.IReserveRepository;
import com.nur.utils.ReserveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class ReserveCrudRepositoryImpl implements IReserveRepository {
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;

    @Override
    public UUID create(Reserve reserve) throws BusinessRuleValidationException {
        Reserve reserveModel = new Reserve(reserve.getId(),reserve.getDateIn(), reserve.getDateOut(), reserve.getDetails(),reserve.getStatus().name(), reserve.getPropiedadId(), reserve.getPersonaId());
        ReserveJpaModel model = ReserveUtils.reserveToJpaEntity(reserveModel);
        return reserveCrudRepository.save(model).getId();
    }

    @Override
    public Reserve getById(UUID id) {
        try {
            ReserveJpaModel jpaModel = reserveCrudRepository.findById(id).orElse(null);
            if(jpaModel == null) return null;
            return ReserveUtils.jpaToReserve(jpaModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reserve> getAll() throws BusinessRuleValidationException{
        List<ReserveJpaModel> jpaModels = Streamable.of(reserveCrudRepository.findAll()).toList();
        List<Reserve> reservas = new ArrayList<>();
        jpaModels.stream().forEach(item -> {
            try {
                reservas.add(ReserveUtils.jpaToReserve(item));
            } catch (BusinessRuleValidationException e) {
                throw new RuntimeException(e);
            }
        });
        return reservas;
    }
}
