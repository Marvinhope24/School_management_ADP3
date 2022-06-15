/*  Kegomoditswe Leshope - 219189048
    CountryFactoryTest.java
    10 June 2022
 */

package za.ac.cput.School_Management.Factory.Employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    void buildWithSuccess() {
        Country country = CountryFactory.build("ZA","South Africa");
        System.out.println(country);
        assertNotNull(country);
    }

    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                CountryFactory.build(null,"South Africa"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("countryId"));
    }
}