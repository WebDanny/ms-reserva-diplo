package com.nur.repositories.persons;

import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;
import com.nur.repositories.IPersonRepository;
import com.nur.utils.PersonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class PersonsCrudRepositoryImpl implements IPersonRepository {
    @Autowired
    private IPersonsCrudRepository personsCrudRepository;

    @Override
    public UUID update(Personas person) {
        Personas persons = new Personas(person.getName(), person.getLastName(), person.getCi());
        PersonaJpaModel model = PersonsUtils.personToJpaEntity(persons);
        return personsCrudRepository.save(model).getId();
    }

    @Override
    public Personas getById(UUID id) {
        try {
            PersonaJpaModel jpaModel = personsCrudRepository.findById(id).orElse(null);
            if(jpaModel == null) return null;
            return PersonsUtils.jpaToPersons(jpaModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Personas> getAll() {
        List<PersonaJpaModel> jpaModels = Streamable.of(personsCrudRepository.findAll()).toList();

        List<Personas> personas = new ArrayList<>();
        jpaModels.stream().forEach(item -> personas.add(PersonsUtils.jpaToPersons(item)));

        return personas;
    }
}
