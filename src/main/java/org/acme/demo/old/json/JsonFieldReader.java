package org.acme.demo.old.json;

import com.google.gson.stream.JsonReader;

import java.nio.file.Path;
import org.acme.demo.old.json.field.JsonField;
import org.acme.demo.old.json.field.JsonFieldName;
import org.acme.demo.old.json.field.values.JsonFieldValue;
import org.acme.demo.old.json.field.values.getters.EmptyGetter;
import org.acme.demo.old.json.field.values.getters.IntSimpleGetter;
import org.acme.demo.old.json.field.values.getters.JsonFieldValueGetter;
import org.acme.demo.old.json.field.values.getters.StringComplexGetter;
import org.acme.demo.old.json.field.values.getters.StringSimpleGetter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonFieldReader {

    private final JsonReader innerReader;

    public JsonFieldReader(Path filePath) throws FileNotFoundException {
        innerReader = new JsonReader(
            new InputStreamReader(new FileInputStream(filePath.toFile()), StandardCharsets.UTF_8));
    }

    public void readInitialFields() throws IOException {
        innerReader.beginObject();

        innerReader.nextName();
        innerReader.nextString();

        innerReader.nextName();
        innerReader.nextString();

        innerReader.nextName();
        innerReader.nextInt();

        innerReader.nextName();
        innerReader.beginArray();
    }

    public void readFinalFields() throws IOException {
        innerReader.endArray();
        innerReader.endObject();
        innerReader.close();
    }

    public boolean hasNextField() throws IOException {
        return innerReader.hasNext();
    }

    public JsonField getNextField() throws IOException {

        JsonFieldName fieldName = JsonFieldName.createFieldName(innerReader.nextName());

        JsonFieldValueGetter valueGetter = getValueGetter(fieldName);

        JsonFieldValue value = valueGetter.get();

        return new JsonField(fieldName, value);
    }

    public void beginMessage() throws IOException {
        innerReader.beginObject();
    }

    public void endMessage() throws IOException {
        innerReader.endObject();
    }


    private JsonFieldValueGetter getValueGetter(JsonFieldName fieldName){

        switch (fieldName){
            case PHOTO_PATH:
            case VIDEO_PATH:
            case DATE:
            case SENDER:
                return new StringSimpleGetter(innerReader);
            case TEXT:
                return new StringComplexGetter(innerReader);
            case ID:
                return new IntSimpleGetter(innerReader);
            default:
                return new EmptyGetter(innerReader);
        }
    }

}
