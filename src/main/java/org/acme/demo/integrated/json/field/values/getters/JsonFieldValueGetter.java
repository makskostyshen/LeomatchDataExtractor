package org.acme.demo.integrated.json.field.values.getters;

import org.acme.demo.integrated.json.field.values.JsonFieldValue;

import java.io.IOException;

public interface JsonFieldValueGetter {
    JsonFieldValue get() throws IOException;
}
