package com.nur.factories.conversation;


import com.nur.model.Conversacion;

public class ConversationFactory implements IConversationFactory{
    @Override
    public Conversacion createConversation(String status) {
        return new Conversacion();
    }
}
