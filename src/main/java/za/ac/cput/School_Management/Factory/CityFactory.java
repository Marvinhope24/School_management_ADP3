/*  Kegomoditswe Leshope - 219189048
    CityFactory.java
    10 June 2022
 */


package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Helper.StringHelper;

public class CityFactory {
    public static City build (String Id, String cityName, Country country){

        StringHelper.isEmptyOrNull("cityId");
        StringHelper.isEmptyOrNull("cityName");
        StringHelper.isEmptyOrNull("country");

        StringHelper.checkStringParam("staffId", Id);
        StringHelper.checkStringParam("staffId", cityName);

        return new City.Builder().cityId(Id).cityName(cityName).country(country).build();

    }


}
