package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.ValidEmail;

public class EmailValueObject extends ValueObject {
    public String value;

    public String getValue() {
        return value;
    }

    public EmailValueObject(String value) throws BusinessRuleValidationException {
        checkRule(new ValidEmail(value));
        this.value = value;
    }
}
