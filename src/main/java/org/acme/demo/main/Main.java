package org.acme.demo.main;

import org.acme.demo.interactions.BasicInteraction;
import org.acme.demo.interactions.BasicInteractionsGetter;
import org.acme.demo.file.parse.messages.Message;
import org.acme.demo.file.parse.messages.MessagesGetter;

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
