package org.acme.demo.integrated.json.field.values;

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
