package org.acme.demo.file.parse.json.field.values.getters;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.acme.demo.file.parse.json.field.values.JsonFieldValue;
import org.acme.demo.file.parse.json.field.values.StringJsonFieldValue;

import java.io.IOException;


public class StringComplexGetter implements JsonFieldValueGetter {

    private final JsonReader reader;

    public StringComplexGetter(JsonReader reader) {
        this.reader = reader;
    }


    @Override
    public JsonFieldValue get() throws IOException {
        if(reader.peek() == JsonToken.STRING){
            return new StringJsonFieldValue(reader.nextString());
        }
        else{
            return getStringFromArray();
        }
    }

    private JsonFieldValue getStringFromArray() throws IOException {
        reader.beginArray();
        StringBuilder builder = new StringBuilder();

        while(reader.hasNext()){
            if(reader.peek() == JsonToken.STRING){
                String nextString = reader.nextString();
                builder.append(nextString);
            }
            else{
                builder.append(getStringFromObject());
            }
        }

        reader.endArray();
        return new StringJsonFieldValue(builder.toString());
    }

    private String getStringFromObject() throws IOException {
        reader.beginObject();
        String significantValue = "";

        while(reader.hasNext()){
            String name = reader.nextName();
            String currentValue = reader.nextString();
            
            if (name.equals("text")){
                significantValue = currentValue;
            }
        }
        reader.endObject();
        return significantValue;
    }


}
