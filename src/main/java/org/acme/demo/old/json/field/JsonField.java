package org.acme.demo.old.json.field;

import org.acme.demo.old.json.field.values.JsonFieldValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JsonField {
    JsonFieldName fieldName;
    JsonFieldValue jsonFieldValue;

    public Object getFieldValue(){
        return jsonFieldValue.getValue();
    }

    @Override
    public String toString() {
        return "name = " + fieldName.getValue() + ", value = " + jsonFieldValue.getValue();
    }
}
