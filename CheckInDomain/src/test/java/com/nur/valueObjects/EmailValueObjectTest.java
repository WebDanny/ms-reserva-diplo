package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValueObjectTest {
    private EmailValueObject emailValueObject;

    @Test
    void testCreationEmailValueObject() {
        assertDoesNotThrow(() -> {
            emailValueObject = new EmailValueObject("cristhian_086@gmail.com");
        });
        assertEquals("cristhian_086@gmail.com", emailValueObject.getValue());
    }

    @Test
    void testInvalidCreationEmailValue() {
        BusinessRuleValidationException validationException = assertThrows(
                BusinessRuleValidationException.class,
                () -> {
                    emailValueObject = new EmailValueObject("");
                }
        );
        assertEquals("Invalid email person", validationException.getMessage());
    }

    @Test
    void testInvalidCreationEmailValueNull() {
        NullPointerException validationException = assertThrows(
                NullPointerException.class,
                () -> {
                    emailValueObject = new EmailValueObject(null);
                }
        );
        assertEquals("Cannot invoke \"String.isEmpty()\" because \"this._email\" is null", validationException.getMessage());
    }
}