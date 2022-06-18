/*  Kegomoditswe Leshope - 219189048
    CityFactoryTest.java
    10 June 2022
 */

package za.ac.cput.School_Management.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;


import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    void buildWithSuccess() {
        Country country = CountryFactory.build("ZA","South Africa");
        City city = CityFactory.build("CPT", "Cape Town",country);
        System.out.println(city);
        assertNotNull(city);
    }

    @Test
    void buildWithError(){
        Country country = CountryFactory.build("ZA","South Africa");
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                CityFactory.build(null,"South Africa",country));
        String ExceptionMessage = exception.getMessage();
        System.out.println(exception);
        assertSame("CityId is required", ExceptionMessage);
    }
}