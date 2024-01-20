package com.nur.rules;

import com.nur.core.IBusinessRule;

public class NotNullRule implements IBusinessRule {
    private Object _value;

    public NotNullRule(Object value) {
        this._value = value;
    }

    @Override
    public String getMessage(){
        return "Object cannot be null";
    }

    public boolean isValid(){
        return _value != null;
    }
}
