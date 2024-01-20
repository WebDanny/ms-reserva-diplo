package com.nur.model;


import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;

import java.util.UUID;


public class Messages extends Entity {
    public UUID userId;
    public String description;
    public StatusMessage status;

    public UUID conversacionId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public StatusMessage getStatus() {
        return status;
    }

    public UUID getConversacionId() {
        return conversacionId;
    }

    public void setConversacionId(UUID conversacionId) {
        this.conversacionId = conversacionId;
    }

    public Messages(UUID userId, String description, UUID conversacionId) {
        id = UUID.randomUUID();
        this.userId = userId;
        this.description = description;
        this.status = StatusMessage.VIGENTE;
        this.conversacionId = conversacionId;
    }

    public void anularMensaje(UUID messageId) throws BusinessRuleValidationException {
        if(messageId == null || messageId.equals("")){
            throw new BusinessRuleValidationException("Error anulando mensaje");
        }
        this.status = StatusMessage.ANULADO;
    }
}
