package com.nur.rules;

import com.nur.core.IBusinessRule;

public class CIRule implements IBusinessRule {

  private final String ci;

  public CIRule(String ci) {
    this.ci = ci;
  }

  @Override
  public boolean isValid() {
    return ci.length() <= 20;
  }

  @Override
  public String getMessage() {
    return "The CI can not be greater than 20 characters";
  }
}
