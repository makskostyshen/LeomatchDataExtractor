package org.acme.demo.integrated.interactions.update;

import org.acme.demo.integrated.interactions.BasicInteractionsHolder;
import org.acme.demo.integrated.messages.Message;

public interface BasicInteractionUpdate {

    void update(BasicInteractionsHolder holder, Message message);
}

