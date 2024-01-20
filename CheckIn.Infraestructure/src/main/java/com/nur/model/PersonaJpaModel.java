package com.nur.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Persona")
public class PersonaJpaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PERSON")
    private UUID id;

    @Column(nullable = false, name = "NAME")
    private String name;

    @Column(nullable = false, name = "LASTNAME")
    private String lastName;

    @Column(nullable = false, name = "CIPERSON")
    private String ci;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}
