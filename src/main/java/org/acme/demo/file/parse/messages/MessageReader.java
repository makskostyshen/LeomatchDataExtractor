package org.acme.demo.file.parse.messages;

import java.nio.file.Path;
import org.acme.demo.file.parse.json.JsonFieldReader;
import org.acme.demo.file.parse.json.field.JsonField;
import org.acme.demo.file.parse.messages.setters.MessageSetter;
import org.acme.demo.file.parse.messages.setters.SetDateTime;
import org.acme.demo.file.parse.messages.setters.SetFrom;
import org.acme.demo.file.parse.messages.setters.SetID;
import org.acme.demo.file.parse.messages.setters.SetNothing;
import org.acme.demo.file.parse.messages.setters.SetPhotoPath;
import org.acme.demo.file.parse.messages.setters.SetText;
import org.acme.demo.file.parse.messages.setters.SetVideoPath;

import java.io.IOException;

public class MessageReader {

    private final JsonFieldReader jsonFieldReader;

    public MessageReader(Path filePath) throws IOException {
        this.jsonFieldReader = new JsonFieldReader(filePath);
    }

    public Message getNextMessage() throws IOException {
        jsonFieldReader.beginMessage();

        Message message = new Message();

        while (jsonFieldReader.hasNextField()) {
            JsonField jsonField = jsonFieldReader.getNextField();

            MessageSetter messageSetter = getMessageFieldSetter(jsonField);

            messageSetter.set(message, jsonField);
        }
        jsonFieldReader.endMessage();

    return message;
    }


    public void open() throws IOException {
        jsonFieldReader.readInitialFields();
    }


    public void close() throws IOException {
        jsonFieldReader.readFinalFields();
    }


    public boolean hasNextMessage() throws IOException {
        return jsonFieldReader.hasNextField();
    }


    private MessageSetter getMessageFieldSetter(JsonField jsonField){

        switch (jsonField.getFieldName()){
            case TEXT:
                return new SetText();
            case ID:
                return new SetID();
            case DATE:
                return new SetDateTime();
            case SENDER:
                return new SetFrom();
            case PHOTO_PATH:
                return new SetPhotoPath();
            case VIDEO_PATH:
                return new SetVideoPath();
            default:
                return new SetNothing();
        }
    }
}
