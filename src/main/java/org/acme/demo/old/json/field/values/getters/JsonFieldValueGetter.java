package org.acme.demo.old.json.field.values.getters;

import org.acme.demo.old.json.field.values.JsonFieldValue;

import java.io.IOException;

public interface JsonFieldValueGetter {
    JsonFieldValue get() throws IOException;
}
