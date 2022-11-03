package org.acme.demo.file.parse.messages.setters;

import utils.DataTransformUtils;
import org.acme.demo.file.parse.json.field.JsonField;
import org.acme.demo.file.parse.messages.Message;

import java.time.LocalDateTime;

public class SetDateTime implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        String dateTimeString = (String) jsonField.getFieldValue();
        message.setDateTime(LocalDateTime.parse(dateTimeString, DataTransformUtils.DATE_TIME_FORMATTER));
    }
}
