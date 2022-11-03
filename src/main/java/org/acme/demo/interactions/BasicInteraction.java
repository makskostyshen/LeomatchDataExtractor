package org.acme.demo.interactions;

import org.acme.demo.interactions.components.MediaFiles;
import org.acme.demo.interactions.components.BotTexts;
import lombok.Getter;
import lombok.Setter;
import org.acme.demo.file.parse.messages.Message;

import java.time.LocalDateTime;

@Setter
@Getter
public class BasicInteraction {

    private int index;

    private BotTexts botTexts;
    private MediaFiles mediaFiles;

    private String userRespond;

    private LocalDateTime userRespondDateTime;
    private LocalDateTime botInquireDateTime;


    public BasicInteraction(){
        this.botTexts = new BotTexts();
        this.mediaFiles = new MediaFiles();
        this.userRespond = "";
        this.userRespondDateTime = null;
        this.botInquireDateTime = null;
        this.index = 0;
    }


    public void setUserMessage(Message userMessage){
        this.userRespond = userMessage.getText();
        this.userRespondDateTime = userMessage.getDateTime();
    }


    public void addGeneralBotMessage(Message botMessage) {
        botTexts.addText(botMessage);
        mediaFiles.addMedia(botMessage);
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(botTexts + " ");
        builder.append(mediaFiles + " ");
        builder.append(userRespond + " ");
        builder.append(botInquireDateTime + " ");
        builder.append(userRespondDateTime + " ");
        return builder.toString();
    }

    public void finishMedia() {
        mediaFiles.addElementsIfTooShort();
    }
}
