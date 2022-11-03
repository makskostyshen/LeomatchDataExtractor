package org.acme.demo.file.parse.json.field.values.getters;

import com.google.gson.stream.JsonReader;
import org.acme.demo.file.parse.json.field.values.JsonFieldValue;
import org.acme.demo.file.parse.json.field.values.StringJsonFieldValue;

import java.io.IOException;

public class EmptyGetter implements JsonFieldValueGetter {

    private final JsonReader reader;

    public EmptyGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public JsonFieldValue get() throws IOException {
        reader.skipValue();
        return new StringJsonFieldValue("");
    }
}