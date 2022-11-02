package org.acme.demo.integrated.messages.setters;

import org.acme.demo.integrated.messages.Message;
import org.acme.demo.integrated.json.field.JsonField;

public class SetVideoPath implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        message.setVideoPath((String) jsonField.getFieldValue());
    }
}
