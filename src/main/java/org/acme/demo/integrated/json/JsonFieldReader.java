package org.acme.demo.integrated.json;

import com.google.gson.stream.JsonReader;

import org.acme.demo.integrated.json.field.JsonField;
import org.acme.demo.integrated.json.field.JsonFieldName;
import org.acme.demo.integrated.json.field.values.JsonFieldValue;
import org.acme.demo.integrated.json.field.values.getters.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonFieldReader {

    private final JsonReader innerReader;

    public JsonFieldReader(String jsonFilePath) throws FileNotFoundException {
        innerReader = new JsonReader(new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8));
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
