package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.StringNotNullOrEmptyRule;

public class PasswordValueObject extends ValueObject {
    public String value;

    public String getValue() {
        return value;
    }

    public PasswordValueObject(String value) throws BusinessRuleValidationException {
        checkRule(new StringNotNullOrEmptyRule(value));
        this.value = value;
    }
}
