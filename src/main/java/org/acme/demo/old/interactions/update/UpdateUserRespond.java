package org.acme.demo.old.interactions.update;

import org.acme.demo.old.interactions.BasicInteractionsHolder;
import org.acme.demo.old.messages.Message;

public class UpdateUserRespond implements BasicInteractionUpdate {

    @Override
    public void update(BasicInteractionsHolder holder, Message message) {
        holder.setUserRespond(message);
    }

}
