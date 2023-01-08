package org.acme.demo.old.messages.setters;

import org.acme.demo.old.json.field.JsonField;
import org.acme.demo.old.messages.Message;

public class SetNothing implements MessageSetter{
    @Override
    public void set(Message message, JsonField jsonField){
        //message doesn't include this type of JsonField
    }
}
