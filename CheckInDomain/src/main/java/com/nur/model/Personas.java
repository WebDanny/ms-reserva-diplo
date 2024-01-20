package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;

import java.util.UUID;

public class Personas extends Entity {
    public String name;
    public String lastName;
    public String ci;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCi() {
        return ci;
    }

    public Personas(String name, String lastName, String ci) {
        id = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
    }

    public Personas() {
    }
}
