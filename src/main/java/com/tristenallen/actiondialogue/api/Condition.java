package com.tristenallen.actiondialogue.api;

import com.tristenallen.actiondialogue.conversation.Conversation;

public interface Condition {
    public boolean check(Conversation conversation);
}
