package org.acme.demo.old.messages.setters;

import org.acme.demo.old.json.field.JsonField;
import org.acme.demo.old.messages.Message;

public class SetFrom implements MessageSetter {
    @Override
    public void set(Message message, JsonField jsonField) {
        message.setSender((String) jsonField.getFieldValue());
    }
}
