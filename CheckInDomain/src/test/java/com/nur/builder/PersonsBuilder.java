package com.nur.builder;

import com.nur.model.Personas;

public class PersonsBuilder {
    public Personas build(){
        return new Personas("Cristhian", "Vargas", "123456");
    }
}
