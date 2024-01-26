package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ReserveTest {
    @Test
    void testCheckCreateReserve() throws BusinessRuleValidationException {

        Reserve reserve = new Reserve(UUID.fromString("e3d515f3-9e82-4075-b42c-64ef643026fa"),"10-10-2023", "10-10-2023", "RESERVE", "Detalle", "e3d515f3-9e82-4075-b42c-64ef643026fa","e3d515f3-9e82-4075-b42c-64ef643026fa");

        assertEquals("10-10-2023", reserve.getDateIn());
        assertEquals("10-10-2023", reserve.getDateOut());
        assertEquals("Detalle", reserve.getDetails());
        assertEquals("RESERVE", reserve.getStatus().name());
        assertNotNull(reserve.getDateIn());
        assertNotNull(reserve.getDateOut());

    }
}