package org.acme.demo.integrated.interactions.update;

import org.acme.demo.integrated.interactions.BasicInteractionsHolder;
import org.acme.demo.integrated.messages.Message;

public class UpdateUserRespond implements BasicInteractionUpdate {

    @Override
    public void update(BasicInteractionsHolder holder, Message message) {
        holder.setUserRespond(message);
    }

}
