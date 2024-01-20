package com.nur.factories.conversation;


import com.nur.model.Conversacion;

public interface IConversationFactory {
    Conversacion createConversation(String status);
}
