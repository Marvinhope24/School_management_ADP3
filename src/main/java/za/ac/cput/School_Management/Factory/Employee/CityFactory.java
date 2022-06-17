/*  Kegomoditswe Leshope - 219189048
    CityFactory.java
    10 June 2022
 */


package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.City;
import za.ac.cput.School_Management.Domain.Employee.Country;
import za.ac.cput.School_Management.Helper.StringHelper;

public class CityFactory {
    public static City build (String cityId, String cityName, Country country){

        StringHelper.isEmptyOrNull("cityId");
        StringHelper.isEmptyOrNull("cityName");
        StringHelper.isEmptyOrNull("country");

        StringHelper.checkStringParam("staffId", cityId);
        StringHelper.checkStringParam("staffId", cityName);

        return new City.Builder().cityId(cityId).cityName(cityName).country(country).build();

    }


}
