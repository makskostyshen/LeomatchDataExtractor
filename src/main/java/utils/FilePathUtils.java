package utils;

public class FilePathUtils {

    private static final String FOLDER_PATH = "C:\\Users\\artemko\\Desktop\\dv";

    private static final String JSON_FILE_NAME = "result.json";
    private static final String CSV_FILE_NAME = "profiles.csv";

    private FilePathUtils(){}

    public static String getJsonFilePath(){
        return getFullPathFromPartial(JSON_FILE_NAME);
    }

    public static String getCsvFileName(){
        return getFullPathFromPartial(CSV_FILE_NAME);
    }

    private static String getFullPathFromPartial(String partialPath){
        return FOLDER_PATH + "\\\\" + partialPath;
    }
}
