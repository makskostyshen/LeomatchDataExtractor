package org.acme.demo.file.parse.interactions.components;

import org.acme.demo.file.parse.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class BotTexts{
    List<String> botTextValues;

    public BotTexts(){
        botTextValues = new ArrayList<>();
    }

    public void addText(Message botMessage) {
        if(botMessage.hasText() || botTextValues.isEmpty()){
            botTextValues.add(botMessage.getText());
        }
    }

    public String get(int index){
        return botTextValues.get(index);
    }

    public int size(){
        return botTextValues.size();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("botTexts: ");

        if(!botTextValues.isEmpty()){
            builder.append(botTextValues.get(0));
        }

        return builder.toString();
    }
}
