package org.acme.demo.file.parse.messages.setters;

import org.acme.demo.file.parse.json.field.JsonField;
import org.acme.demo.file.parse.messages.Message;

public class SetText implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        message.setText((String) jsonField.getFieldValue());
    }
}
