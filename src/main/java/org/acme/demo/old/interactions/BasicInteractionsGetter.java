package org.acme.demo.old.interactions;

import org.acme.demo.old.interactions.update.BasicInteractionUpdate;
import org.acme.demo.old.interactions.update.BasicInteractionUpdateGetter;
import org.acme.demo.old.messages.Message;

import java.util.List;

public class BasicInteractionsGetter {

    public List<BasicInteraction> getInteractions(List<Message> messages){

        BasicInteractionsHolder holder = new BasicInteractionsHolder();
        BasicInteractionUpdateGetter basicInteractionUpdateGetter = new BasicInteractionUpdateGetter();

        for (Message message: messages){

            BasicInteractionUpdate update = basicInteractionUpdateGetter.getUpdate(message);
            update.update(holder, message);
        }

        return holder.getBasicInteractions();
    }
}
