package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValorationValueObjectTest {
    private ValorationValueObject valorationValueObject;

    @Test
    void testCheckValorationValueObject() {
        assertDoesNotThrow(() -> {
            valorationValueObject = new ValorationValueObject(3);
        });
        assertEquals(3, valorationValueObject.getPoints());
    }

    @Test
    void testCheckInvalidValoration() {
        BusinessRuleValidationException exception = assertThrows(BusinessRuleValidationException.class, () -> {
            valorationValueObject = new ValorationValueObject(-1);
        });
        assertEquals("Points invalidos", exception.getMessage());
    }
}