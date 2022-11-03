package org.acme.demo.interactions.update;

import utils.BotUtils;
import org.acme.demo.file.parse.messages.Message;

public class BasicInteractionUpdateGetter {


    public BasicInteractionUpdate getUpdate(Message message){
        String senderName = message.getSender();

        if (senderName.equals(BotUtils.BOT_NAME)){
            return new UpdateBotInquire();
        }
        else{
            return new UpdateUserRespond();
        }
    }

}
