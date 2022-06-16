/*  Kegomoditswe Leshope - 219189048
    CountryFactory.java
    10 June 2022
 */


package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Country;

public class CountryFactory {
    public static Country build(String countryId, String countryName){
        if (countryId == null || countryId.isEmpty())
            throw new IllegalArgumentException("CountryId is required");

        if (countryName == null || countryName.isEmpty())
            throw new IllegalArgumentException("CountryName is required");

        return new Country.Builder().countryId(countryId).countryName(countryName).build();

    }
}
