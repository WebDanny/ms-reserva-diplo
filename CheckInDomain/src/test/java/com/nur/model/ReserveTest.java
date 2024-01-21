package com.nur.model;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.core.BusinessRuleValidationException;
import java.util.Date;
import org.junit.jupiter.api.Test;

class ReserveTest {
  @Test
  void testCheckCreateReserve() throws BusinessRuleValidationException {
    Date fechaLlegada = new Date();
    Date fechaFinalizacion = new Date();
    Propiedad propiedad = new Propiedad();
    Reserve reserve = new Reserve(fechaLlegada, fechaFinalizacion, "Detalle", propiedad);
    assertEquals(fechaLlegada, reserve.getDateIn());
    assertEquals(fechaFinalizacion, reserve.getDateOut());
    assertEquals("Detalle", reserve.getDetails());
    assertEquals("RESERVE", reserve.getStatus().name());
    assertNotNull(reserve.getDateIn());
    assertNotNull(reserve.getDateOut());
  }
}
