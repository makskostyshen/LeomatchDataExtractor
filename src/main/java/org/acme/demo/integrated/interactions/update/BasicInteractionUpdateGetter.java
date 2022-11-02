package org.acme.demo.integrated.interactions.update;

import org.acme.demo.integrated.utils.BotUtils;
import org.acme.demo.integrated.messages.Message;

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
