package org.acme.demo.interactions.update;

import org.acme.demo.interactions.BasicInteractionsHolder;
import org.acme.demo.file.parse.messages.Message;

public class UpdateUserRespond implements BasicInteractionUpdate {

    @Override
    public void update(BasicInteractionsHolder holder, Message message) {
        holder.setUserRespond(message);
    }

}
