package org.acme.demo.integrated.messages;

import org.acme.demo.integrated.utils.DataTransformUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Message {

    protected Integer id = 0;
    protected LocalDateTime dateTime = null;
    protected String sender = "";
    protected String text = "";

    private String photoPath = "";
    private String videoPath = "";

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "date: " + dateTime + "\n" +
                "from: " + sender + "\n" +
                "text: " + text + "\n" +
                "photo: " + photoPath + "\n" +
                "video: " + videoPath + "\n";
    }


    public boolean hasPhoto(){
        return !photoPath.equals("");
    }

    public boolean hasVideo(){
        return !videoPath.equals("");
    }

    public boolean hasText() { return !text.equals(""); }

    public static Message createFirstMessage(){
        Message firstMessage = new Message();
        firstMessage.setText(DataTransformUtils.BLANK_MESSAGE_TEXT);
        firstMessage.setDateTime(LocalDateTime.MIN);

        return firstMessage;
    }
}