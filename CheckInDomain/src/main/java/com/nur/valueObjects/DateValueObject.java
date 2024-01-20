package com.nur.valueObjects;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.ValidDate;

import java.util.Date;

public class DateValueObject extends ValueObject {
    public DateValueObject(Date dateIn, Date dateOut) throws BusinessRuleValidationException {
        checkRule(new ValidDate(dateIn, dateOut));
    }
}
