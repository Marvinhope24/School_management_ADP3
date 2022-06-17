/*  Kegomoditswe Leshope - 219189048
    CountryFactory.java
    10 June 2022
 */


package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Helper.StringHelper;

public class CountryFactory {
    public static Country build(String Id, String countryName){

        StringHelper.isEmptyOrNull("countryId");
        StringHelper.isEmptyOrNull("countryName");

        StringHelper.checkStringParam("countryId", Id);
        StringHelper.checkStringParam("countryName", countryName);

        return new Country.Builder().countryId(Id).countryName(countryName).build();

    }
}
