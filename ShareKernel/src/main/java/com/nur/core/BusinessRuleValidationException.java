package com.nur.core;

public class BusinessRuleValidationException extends Exception{
    private IBusinessRule brokenRule;
    private String message;

    public BusinessRuleValidationException(IBusinessRule brokenRule) {
        this.brokenRule = brokenRule;
        this.message = brokenRule.getMessage();
    }

    public BusinessRuleValidationException(String message) {
        this.message = message;
    }

    public IBusinessRule getBrokenRule() {
        return brokenRule;
    }

    public void setBrokenRule(IBusinessRule brokenRule) {
        this.brokenRule = brokenRule;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BusinessRuleValidationException{" +
                "message='" + message + '\'' +
                '}';
    }
}
