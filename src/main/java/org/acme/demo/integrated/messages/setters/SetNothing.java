package org.acme.demo.integrated.messages.setters;

import org.acme.demo.integrated.json.field.JsonField;
import org.acme.demo.integrated.messages.Message;

public class SetNothing implements MessageSetter{
    @Override
    public void set(Message message, JsonField jsonField){
        //message doesn't include this type of JsonField
    }
}
