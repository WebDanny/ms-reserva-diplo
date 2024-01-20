package com.nur.core;

public abstract class ValueObject {
    protected void checkRule(IBusinessRule rule) throws BusinessRuleValidationException{
        if(rule == null){
            throw new IllegalArgumentException("Rule cannot be null");
        }

        if(rule.isValid()){
            throw new BusinessRuleValidationException(rule);
        }
    }
}
