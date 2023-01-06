package org.acme.demo.file.parse.json.field.values;

public class IntJsonFieldValue implements JsonFieldValue {
    private final int value;

    public IntJsonFieldValue(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
