package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValueObjectTest {
    private PasswordValueObject passwordValueObject;

    @Test
    void testCheckPasswordCreatingValueObject() {
        assertDoesNotThrow(() -> {
            passwordValueObject = new PasswordValueObject("123456");
        });
        assertEquals("123456", passwordValueObject.getValue());
    }

    @Test
    void testInvalidCreationPasswordValueObject() {
        BusinessRuleValidationException validationException = assertThrows(
                BusinessRuleValidationException.class,
                () -> {
                    passwordValueObject = new PasswordValueObject("");
                }
        );
        assertEquals("string cannot be null", validationException.getMessage());
    }

    @Test
    void testSecondInvalidCreationPasswordValueObject() {
        BusinessRuleValidationException validationException = assertThrows(
                BusinessRuleValidationException.class,
                () -> {
                    passwordValueObject = new PasswordValueObject(null);
                }
        );
        assertEquals("string cannot be null", validationException.getMessage());
    }
}