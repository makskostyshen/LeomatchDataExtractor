package org.acme.demo.old.interactions.update;

import org.acme.demo.old.interactions.BasicInteractionsHolder;
import org.acme.demo.old.messages.Message;

public interface BasicInteractionUpdate {

    void update(BasicInteractionsHolder holder, Message message);
}

