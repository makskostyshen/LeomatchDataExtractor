package org.acme.demo.old.json.field.values.getters;

import com.google.gson.stream.JsonReader;
import org.acme.demo.old.json.field.values.JsonFieldValue;
import org.acme.demo.old.json.field.values.StringJsonFieldValue;

import java.io.IOException;

public class StringSimpleGetter implements JsonFieldValueGetter {

    private final JsonReader reader;

    public StringSimpleGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public JsonFieldValue get() throws IOException {
        return new StringJsonFieldValue(reader.nextString());
    }
}
