package org.acme.demo.integrated.messages.setters;

import org.acme.demo.integrated.json.field.JsonField;
import org.acme.demo.integrated.messages.Message;

public class SetText implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        message.setText((String) jsonField.getFieldValue());
    }
}
