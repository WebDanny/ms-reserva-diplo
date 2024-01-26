package com.nur.util;

import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Persona;
import com.nur.model.Personas;
import com.nur.model.Propiedad;
import com.nur.model.Reserve;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PersonMapper {
    public static PersonDTO from(Personas person) {
        if (person == null) return new PersonDTO();
        return new PersonDTO(
                person.getId() == null ? String.valueOf(UUID.randomUUID()) : String.valueOf(person.getId()),
                person.getName() == null ? "" : person.getName(),
                person.getLastName() == null ? "" : person.getLastName(),
                person.getCi() == null ? "" : person.getCi(),
                person.getReservas() == null ? null : fromObjetToReserveDTO(person.getReservas())
        );
    }

    public static Personas from(PersonDTO person) {
        return new Personas(
                person.getName(),
                person.getLastName(),
                person.getCi()

        );
    }

    public static List<ReserveDTO> fromObjetToReserveDTO(List<Reserve> reserveList) {
        List<ReserveDTO> reserveDTOS = new ArrayList<>();
        for (int i = 0; i < reserveList.size(); i++) {

            ReserveDTO reserveDTO = new ReserveDTO();
            reserveDTO.id = String.valueOf(reserveList.get(i).getId());
            reserveDTO.dateIn = reserveList.get(i).getDateIn();
            reserveDTO.dateOut = reserveList.get(i).getDateOut();
            reserveDTO.details = reserveList.get(i).getDetails();
            reserveDTOS.add(reserveDTO);
        }


        return reserveDTOS;
    }

    public static List<Reserve> fromDTOtoObject(List<ReserveDTO> reserveList) {
        List<Reserve> reserveDTOS = new ArrayList<>();
        for (int i = 0; i < reserveList.size(); i++) {

            Reserve reserve = new Reserve();
            reserve.id = UUID.fromString(reserveList.get(i).getId());
            reserve.dateIn = reserveList.get(i).getDateIn();
            reserve.dateOut = reserveList.get(i).getDateOut();
            reserve.details = reserveList.get(i).getDetails();
            reserveDTOS.add(reserve);
        }


        return reserveDTOS;
    }
}
