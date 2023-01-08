package org.acme.demo.file.parse.messages.setters;

import org.acme.demo.file.parse.json.field.JsonField;
import org.acme.demo.file.parse.messages.Message;

public interface MessageSetter {
    void set(Message message, JsonField jsonField);
}
