package com.nur.utils;

import com.nur.dtos.ReserveDTO;
import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonsUtils {
    public static PersonaJpaModel personToJpaEntity(Personas person) {
        PersonaJpaModel model = new PersonaJpaModel();
        model.setId(person.getId());
        model.setName(person.getName());
        model.setLastName(person.getLastName());
        model.setCi(person.getCi());
     //   model.setReservas(fromReserveToJpa(person.getReservas()));
        return model;
    }

    public static Personas jpaToPersons(PersonaJpaModel jpaModel) {
        return new Personas(
                jpaModel.getName(),
                jpaModel.getLastName(),
                jpaModel.getCi()
        );
    }

    public static List<ReserveJpaModel> fromReserveToJpa(List<Reserve> reserveList) {
        List<ReserveJpaModel> reserveDTOS = new ArrayList<>();
        for (int i = 0; i < reserveList.size(); i++) {

            ReserveJpaModel reserveDTO = new ReserveJpaModel();
            reserveDTO.setId(reserveList.get(i).getId());
            reserveDTO.setDateIn(reserveList.get(i).getDateIn());
            reserveDTO.setDateOut(reserveList.get(i).getDateOut());
            reserveDTO.setDetails(reserveList.get(i).getDetails());
            reserveDTOS.add(reserveDTO);
        }


        return reserveDTOS;
    }

    public static List<Reserve> fromJpaToReserve(List<ReserveJpaModel> reserveList) {
        List<Reserve> reserveDTOS = new ArrayList<>();
        for (int i = 0; i < reserveList.size(); i++) {

            Reserve reserve = new Reserve();
            reserve.id = reserveList.get(i).getId();
            reserve.dateIn = reserveList.get(i).getDateIn();
            reserve.dateOut = reserveList.get(i).getDateOut();
            reserve.details = reserveList.get(i).getDetails();
            reserveDTOS.add(reserve);
        }
        return reserveDTOS;
    }
}
