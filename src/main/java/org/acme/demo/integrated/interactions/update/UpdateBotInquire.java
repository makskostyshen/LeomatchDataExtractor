package org.acme.demo.integrated.interactions.update;

import org.acme.demo.integrated.interactions.BasicInteractionsHolder;
import org.acme.demo.integrated.messages.Message;

public class UpdateBotInquire implements BasicInteractionUpdate {

    @Override
    public void update(BasicInteractionsHolder holder, Message message) {

        holder.addBotMessage(message);
    }
}
