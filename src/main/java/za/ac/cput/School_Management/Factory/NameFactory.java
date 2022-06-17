package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Helper.StringHelper;

public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName){
        StringHelper.isEmptyOrNull("First Name");
        StringHelper.isEmptyOrNull("Last Name");
        StringHelper.isEmptyOrNull("middleName");

        StringHelper.checkStringParam("First Name", firstName);
        StringHelper.checkStringParam("Last Name", lastName);
        StringHelper.checkStringParam( "middleName",middleName);

        return new Name.Builder().firstname(firstName).MiddleName(middleName).LastName(lastName).build();
    }
}
