package org.acme.demo.file.parse.interactions.update;

import org.acme.demo.file.parse.interactions.BasicInteractionsHolder;
import org.acme.demo.file.parse.messages.Message;

public class UpdateBotInquire implements BasicInteractionUpdate {

    @Override
    public void update(BasicInteractionsHolder holder, Message message) {

        holder.addBotMessage(message);
    }
}
