package org.acme.demo.old.messages.setters;

import org.acme.demo.utils.DataTransformUtils;
import org.acme.demo.old.json.field.JsonField;
import org.acme.demo.old.messages.Message;

import java.time.LocalDateTime;

public class SetDateTime implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        String dateTimeString = (String) jsonField.getFieldValue();
        message.setDateTime(LocalDateTime.parse(dateTimeString, DataTransformUtils.DATE_TIME_FORMATTER));
    }
}
