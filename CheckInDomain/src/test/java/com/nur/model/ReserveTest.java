package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReserveTest {
    @Test
    void testCheckCreateReserve() throws BusinessRuleValidationException {
        Date fechaLlegada = new Date();
        Date fechaFinalizacion =  new Date();
        Reserve reserve = new Reserve(fechaLlegada, fechaFinalizacion, "Detalle");

        assertEquals(fechaLlegada, reserve.getDateIn());
        assertEquals(fechaFinalizacion, reserve.getDateOut());
        assertEquals("Detalle", reserve.getDetails());
        assertEquals("RESERVE", reserve.getStatus().name());
        assertNotNull(reserve.getDateIn());
        assertNotNull(reserve.getDateOut());

    }
}