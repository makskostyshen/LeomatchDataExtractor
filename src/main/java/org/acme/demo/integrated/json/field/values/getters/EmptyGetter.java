package org.acme.demo.integrated.json.field.values.getters;

import com.google.gson.stream.JsonReader;
import org.acme.demo.integrated.json.field.values.JsonFieldValue;
import org.acme.demo.integrated.json.field.values.StringJsonFieldValue;

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