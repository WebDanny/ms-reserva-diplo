package com.nur.rules;

import com.nur.core.IBusinessRule;

public class NotNegativeRule implements IBusinessRule {
    private double _value;

    public NotNegativeRule(double value){
        _value = value;
    }

    public boolean isValid(){
        return _value >= 0;
    }

    @Override
    public String getMessage() {
        return "Value cannot be negative";
    }

}
