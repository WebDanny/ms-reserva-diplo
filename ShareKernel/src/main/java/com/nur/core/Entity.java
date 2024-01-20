package com.nur.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Entity {
    public UUID id;
    public List<DomainEvent> domainEvents;

    public Entity() {
        this.id = UUID.randomUUID();
        this.domainEvents = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    protected void setId(UUID id) {
        this.id = id;
    }

    public List<DomainEvent> getDomainEvents() {
        return new ArrayList<>(domainEvents);
    }

    public void addDomainEvent(DomainEvent event){
        domainEvents.add(event);
    }

    public void clearDomainEvents(){
        domainEvents.clear();
    }

    protected void checkRule(IBusinessRule rule) throws Exception {
        if(rule == null){
            throw new Exception("Rule cannot be null");
        }
        if(!rule.isValid()){
            throw new BusinessRuleValidationException(rule);
        }
    }

    public boolean equals(Object obj){
        return obj != null && id == ((Entity) obj).id;
    }
}
