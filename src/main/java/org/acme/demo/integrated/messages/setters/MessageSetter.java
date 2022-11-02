package org.acme.demo.integrated.messages.setters;

import org.acme.demo.integrated.json.field.JsonField;
import org.acme.demo.integrated.messages.Message;

public interface MessageSetter {
    void set(Message message, JsonField jsonField);
}
