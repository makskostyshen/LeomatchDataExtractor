package org.acme.demo.file.parse.json.field;

import java.util.*;

public enum JsonFieldName {

    ID("id"),
    DATE("date"),
    SENDER("from"),
    TEXT("text"),
    PHOTO_PATH("photo"),
    VIDEO_PATH("file"),
    OTHER("empty");


    private final String value;

    JsonFieldName(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JsonFieldName createFieldName(String value){

        JsonFieldName jsonFieldName = FIELD_NAME_GETTER.get(value);

        return Objects.requireNonNullElse(jsonFieldName, OTHER);
    }

    private static final Map<String, JsonFieldName> FIELD_NAME_GETTER = new HashMap<>(){{
        put("id", JsonFieldName.ID);
        put("date", JsonFieldName.DATE);
        put("from", JsonFieldName.SENDER);
        put("photo", JsonFieldName.PHOTO_PATH);
        put("file", JsonFieldName.VIDEO_PATH);
        put("text", JsonFieldName.TEXT);
    }};

}
