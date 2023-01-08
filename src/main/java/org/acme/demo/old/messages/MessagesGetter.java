package org.acme.demo.old.messages;

import java.nio.file.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessagesGetter {
    private Path filePath;

    public MessagesGetter(Path filePath) {
        this.filePath = filePath;
    }

    public List<Message> getMessages() throws IOException {

        List<Message> messages = new ArrayList<>();

        MessageReader messageReader = new MessageReader(filePath);
        messageReader.open();

        while (messageReader.hasNextMessage()){

            Message newMessage = messageReader.getNextMessage();
            messages.add(newMessage);
        }

        messageReader.close();
        return messages;
    }

}

