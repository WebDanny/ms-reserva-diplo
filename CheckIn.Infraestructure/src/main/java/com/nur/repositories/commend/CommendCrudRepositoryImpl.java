package com.nur.repositories.commend;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import com.nur.model.CommendJpaModel;
import com.nur.repositories.ICommendRepository;
import com.nur.utils.CommendUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class CommendCrudRepositoryImpl implements ICommendRepository {

    @Autowired
    private ICommendCrudRepository commendCrudRepository;

    @Override
    public UUID update(Commend commend) throws BusinessRuleValidationException {
        Commend commends = new Commend(commend.getUserId(), commend.getValoracion(), commend.getComentario(), commend.getPropiedad(), commend.getPoints());
        CommendJpaModel model = CommendUtils.commendToJpaEntity(commends);
        return commendCrudRepository.save(model).getId();
    }

    @Override
    public Commend getById(UUID id) {
        try {
        CommendJpaModel jpaModel = commendCrudRepository.findById(id).orElse(null);
        if(jpaModel == null) return null;
        return CommendUtils.jpaToCommend(jpaModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Commend> getAll() {
        List<CommendJpaModel> jpaModels = Streamable.of(commendCrudRepository.findAll()).toList();
        List<Commend> commends = new ArrayList<>();
        jpaModels.stream().forEach(item -> {
            try {
                commends.add(CommendUtils.jpaToCommend(item));
            } catch (BusinessRuleValidationException e) {
                throw new RuntimeException(e);
            }
        });
        return commends;
    }
}
