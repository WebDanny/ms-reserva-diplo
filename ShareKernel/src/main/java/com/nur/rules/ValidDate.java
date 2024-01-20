package com.nur.rules;

import com.nur.core.IBusinessRule;

import java.util.Date;

public class ValidDate implements IBusinessRule {
    private final Date _dateIn;
    private final Date _dateOut;

    public ValidDate(Date dateIn, Date dateOut) {
        this._dateIn = dateIn;
        this._dateOut = dateOut;
    }

    @Override
    public boolean isValid() {
        return _dateOut.getTime() > _dateIn.getTime();
    }

    @Override
    public String getMessage() {
        return "No puede ser mayor la fecha de llegada que la de salida";
    }
}