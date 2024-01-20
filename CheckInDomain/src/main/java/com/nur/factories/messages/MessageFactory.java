package com.nur.factories.messages;


import com.nur.model.Messages;

import java.util.UUID;

public class MessageFactory implements IMessageFactory{
    @Override
    public Messages saveMessage(UUID userId, String content, UUID conversationId) {
        return new Messages(userId, content, conversationId);
    }
}
