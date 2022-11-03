package org.acme.demo.interactions.update;

import org.acme.demo.interactions.BasicInteractionsHolder;
import org.acme.demo.file.parse.messages.Message;

public interface BasicInteractionUpdate {

    void update(BasicInteractionsHolder holder, Message message);
}

