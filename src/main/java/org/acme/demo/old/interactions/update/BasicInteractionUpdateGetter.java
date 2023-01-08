package org.acme.demo.old.interactions.update;

import org.acme.demo.utils.BotUtils;
import org.acme.demo.old.messages.Message;

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
