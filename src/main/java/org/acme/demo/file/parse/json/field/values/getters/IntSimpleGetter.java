package org.acme.demo.file.parse.json.field.values.getters;

import com.google.gson.stream.JsonReader;
import org.acme.demo.file.parse.json.field.values.IntJsonFieldValue;
import org.acme.demo.file.parse.json.field.values.JsonFieldValue;

import java.io.IOException;

public class IntSimpleGetter implements JsonFieldValueGetter {

    private final JsonReader reader;

    public IntSimpleGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public JsonFieldValue get() throws IOException {
        return new IntJsonFieldValue(reader.nextInt());
    }
}
