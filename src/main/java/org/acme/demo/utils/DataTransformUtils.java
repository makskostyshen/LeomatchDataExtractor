package org.acme.demo.utils;

import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class DataTransformUtils {
    private DataTransformUtils(){}

    public static final String NEW_LINE = "\\\\n";

    public static final String NEW_LINE_GENERAL = "\n";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = ISO_LOCAL_DATE_TIME;

    public static final String BLANK_MESSAGE_TEXT = "<<<blank message>>>";

    public static final String BLANK_MESSAGE_PHOTO_PATH = "photo_3@14-01-2020_15-36-38.jpg";
}
