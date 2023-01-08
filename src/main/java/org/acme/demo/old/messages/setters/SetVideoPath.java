package org.acme.demo.old.messages.setters;

import org.acme.demo.old.messages.Message;
import org.acme.demo.old.json.field.JsonField;

public class SetVideoPath implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        message.setVideoPath((String) jsonField.getFieldValue());
    }
}
