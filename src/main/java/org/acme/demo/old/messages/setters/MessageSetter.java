package org.acme.demo.old.messages.setters;

import org.acme.demo.old.json.field.JsonField;
import org.acme.demo.old.messages.Message;

public interface MessageSetter {
    void set(Message message, JsonField jsonField);
}
