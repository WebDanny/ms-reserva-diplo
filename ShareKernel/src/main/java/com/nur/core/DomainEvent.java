package com.nur.core;

import java.time.LocalDate;
import java.util.UUID;

public abstract class DomainEvent {
    public LocalDate occurredOn;
    public UUID id;

    public boolean consumed;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(LocalDate occurredOn) {
        this.occurredOn = occurredOn;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    protected DomainEvent(LocalDate occurredOn){
        this.id = UUID.randomUUID();
        this.occurredOn = occurredOn;
    }

    public void markAsConsumed(){
        consumed = true;
    }

}
