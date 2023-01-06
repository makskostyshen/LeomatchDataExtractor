package org.acme.demo.file.parse.json.field.values.getters;

import org.acme.demo.file.parse.json.field.values.JsonFieldValue;

import java.io.IOException;

public interface JsonFieldValueGetter {
    JsonFieldValue get() throws IOException;
}
