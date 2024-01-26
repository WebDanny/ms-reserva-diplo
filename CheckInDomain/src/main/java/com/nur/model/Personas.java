package com.nur.model;

import com.nur.core.Entity;

import java.util.List;

public class Personas extends Entity {
    public String name;
    public String lastName;
    public String ci;
    private List<Reserve> reservas;

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
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
        this.reservas = reservas;
    }

    public Personas() {
    }

    public List<Reserve> getReservas() {
        return reservas;
    }
}
