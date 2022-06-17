package za.ac.cput.School_Management.Helper;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;


public class StringHelper {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
    public static boolean ValidateEmail(String ExampleEmail, String regexString ) {
        return Pattern.compile(regexString)
                .matcher(ExampleEmail)
                .matches();
    }
}