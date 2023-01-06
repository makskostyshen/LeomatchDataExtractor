package org.acme.demo.file.parse.interactions;

import lombok.Getter;
import lombok.Setter;
import org.acme.demo.file.parse.messages.Message;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BasicInteractionsHolder {
    private List<BasicInteraction> basicInteractions;
    private BasicInteraction currentBasicInteraction;
    private BasicInteractionCreator interactionCreator;


    public BasicInteractionsHolder() {
        basicInteractions = new ArrayList<>();
        interactionCreator = new BasicInteractionCreator();
        currentBasicInteraction = interactionCreator.getPreviousInteraction();
    }

    public void addBotMessage(Message message){
        if (interactionCreator.isBlank(currentBasicInteraction)){
            currentBasicInteraction = interactionCreator.createInteractionFromMessage(message);
        }
        else {
            currentBasicInteraction.addGeneralBotMessage(message);
        }
    }

    public void setUserRespond(Message userMessage){
        currentBasicInteraction.setUserMessage(userMessage);
        finishInteraction();
    }


    private void finishInteraction(){
        currentBasicInteraction.finishMedia();
        basicInteractions.add(currentBasicInteraction);
        currentBasicInteraction = interactionCreator.createBlankInteraction();
    }

}
