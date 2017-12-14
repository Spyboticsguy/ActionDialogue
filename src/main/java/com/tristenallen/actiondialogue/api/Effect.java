package com.tristenallen.actiondialogue.api;

import com.tristenallen.actiondialogue.conversation.Conversation;

public interface Effect {
    public void execute(Conversation conversation);
}
