package org.acme.demo.integrated.messages.setters;

import org.acme.demo.integrated.utils.DataTransformUtils;
import org.acme.demo.integrated.json.field.JsonField;
import org.acme.demo.integrated.messages.Message;

import java.time.LocalDateTime;

public class SetDateTime implements MessageSetter {

    @Override
    public void set(Message message, JsonField jsonField) {
        String dateTimeString = (String) jsonField.getFieldValue();
        message.setDateTime(LocalDateTime.parse(dateTimeString, DataTransformUtils.DATE_TIME_FORMATTER));
    }
}
