package org.acme.demo.old.json.field.values;


import org.acme.demo.old.utils.DataTransformUtils;

public class StringJsonFieldValue implements JsonFieldValue {

    private final String value;

    public StringJsonFieldValue(String value){
        this.value = value.replaceAll(DataTransformUtils.NEW_LINE_GENERAL, DataTransformUtils.NEW_LINE);
    }

    @Override
    public String getValue() {
        return value;
    }
}
