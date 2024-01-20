package com.nur.rules;

import com.nur.core.IBusinessRule;

public class ValidPointsRule implements IBusinessRule {
    public int value;

    public ValidPointsRule(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return this.value < 0;
    }

    @Override
    public String getMessage() {
        return "Points invalidos";
    }
}
