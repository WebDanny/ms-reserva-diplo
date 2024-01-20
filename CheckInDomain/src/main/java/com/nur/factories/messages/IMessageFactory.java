package com.nur.factories.messages;


import com.nur.model.Messages;

import java.util.UUID;

public interface IMessageFactory {
    Messages saveMessage(UUID userId, String content, UUID conversationId);
}
