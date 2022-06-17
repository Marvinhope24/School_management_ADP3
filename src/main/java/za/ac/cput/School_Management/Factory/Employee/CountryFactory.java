/*  Kegomoditswe Leshope - 219189048
    CountryFactory.java
    10 June 2022
 */


package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Country;
import za.ac.cput.School_Management.Helper.StringHelper;

public class CountryFactory {
    public static Country build(String countryId, String countryName){

        StringHelper.isEmptyOrNull("countryId");
        StringHelper.isEmptyOrNull("countryName");

        StringHelper.checkStringParam("countryId", countryId);
        StringHelper.checkStringParam("countryName", countryName);

        return new Country.Builder().countryId(countryId).countryName(countryName).build();

    }
}
