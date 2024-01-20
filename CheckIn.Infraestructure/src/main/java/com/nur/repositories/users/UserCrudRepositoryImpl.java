package com.nur.repositories.users;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.UserJpaModel;
import com.nur.model.Usuario;
import com.nur.repositories.IUserRepository;
import com.nur.utils.UsersUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class UserCrudRepositoryImpl implements IUserRepository{
    @Autowired
    private IUserCrudRepository userRepository;

    @Override
    public UUID update(Usuario user) throws BusinessRuleValidationException {
        Usuario users = new Usuario(user.getUsername(), user.getEmail(), user.getPass(), user.getAccountType(), user.getPersonId());
        UserJpaModel model = UsersUtils.userToJpaEntity(users);
        return userRepository.save(model).getId();
    }

    @Override
    public Usuario getById(UUID id) {
        try {
            UserJpaModel jpaModel = userRepository.findById(id).orElse(null);
            if(jpaModel == null) throw new BusinessRuleValidationException("Error");
            return UsersUtils.jpaToUser(jpaModel);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> getAll() {
        List<UserJpaModel> jpaModels = Streamable.of(userRepository.findAll()).toList();

        List<Usuario> users = new ArrayList<>();
        jpaModels.stream().forEach(item -> {
            try {
                users.add(UsersUtils.jpaToUser(item));
            } catch (BusinessRuleValidationException e) {
                throw new RuntimeException(e);
            }
        });
        return users;
    }
}
