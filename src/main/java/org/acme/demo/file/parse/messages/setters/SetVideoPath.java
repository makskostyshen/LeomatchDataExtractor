package org.acme.demo.file.parse.messages.setters;

import org.acme.demo.file.parse.messages.Message;
import org.acme.demo.file.parse.json.field.JsonField;

public class SetVideoPath implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        message.setVideoPath((String) jsonField.getFieldValue());
    }
}
