package za.ac.cput.School_Management.Helper;

import org.apache.commons.lang3.StringUtils;

public class StringHelper {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }
    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
}