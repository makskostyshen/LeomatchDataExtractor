package org.acme.demo.integrated.main;

import org.acme.demo.integrated.interactions.BasicInteraction;
import org.acme.demo.integrated.messages.Message;

import java.util.List;

public class ConsolePrinter {

    private static final String DELIMITER = "===============";

    private ConsolePrinter(){}

    public static void printMessages(List<Message> messages){
        for (Message message: messages){
            System.out.println(message);
            System.out.println(DELIMITER);
        }
    }

    public static void printInteractions(List<BasicInteraction> basicInteractions){

        for (BasicInteraction basicInteraction : basicInteractions){
            System.out.println(basicInteraction);
        }

    }
}
