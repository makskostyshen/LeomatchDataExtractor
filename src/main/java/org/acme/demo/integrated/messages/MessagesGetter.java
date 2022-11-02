package org.acme.demo.integrated.messages;

import org.acme.demo.integrated.utils.FilePathUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessagesGetter {

    public List<Message> getMessages() throws IOException {

        List<Message> messages = new ArrayList<>();

        MessageReader messageReader = new MessageReader(FilePathUtils.getJsonFilePath());
        messageReader.open();

        while (messageReader.hasNextMessage()){

            Message newMessage = messageReader.getNextMessage();
            messages.add(newMessage);
        }

        messageReader.close();
        return messages;
    }

}

