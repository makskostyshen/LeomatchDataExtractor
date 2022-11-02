package org.acme.demo.integrated.main;

import org.acme.demo.integrated.interactions.BasicInteraction;
import org.acme.demo.integrated.interactions.BasicInteractionsGetter;
import org.acme.demo.integrated.messages.Message;
import org.acme.demo.integrated.messages.MessagesGetter;

import java.util.List;

public class Main {
    public static void main(String[] args){

        try {
            MessagesGetter messagesGetter = new MessagesGetter();
            List<Message> messages = messagesGetter.getMessages();

            BasicInteractionsGetter interactionGetter = new BasicInteractionsGetter();
            List<BasicInteraction> basicInteractions = interactionGetter.getInteractions(messages);
            ConsolePrinter.printInteractions(basicInteractions);
        }
        catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

}
