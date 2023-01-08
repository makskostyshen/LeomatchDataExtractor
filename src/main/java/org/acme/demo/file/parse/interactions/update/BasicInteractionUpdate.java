package org.acme.demo.file.parse.interactions.update;

import org.acme.demo.file.parse.interactions.BasicInteractionsHolder;
import org.acme.demo.file.parse.messages.Message;

public interface BasicInteractionUpdate {

    void update(BasicInteractionsHolder holder, Message message);
}

