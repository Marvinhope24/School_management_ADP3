//Marvin Hope - 219445842
// AddressFactoryTest.java
// 18 June 2022

package za.ac.cput.School_Management.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.*;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    public void buildWithSuccess() {
        Country country = CountryFactory.build("3659","South Africa");
        City city = CityFactory.build("1985","Cape Town", country);
        Address address = AddressFactory.build("354","Complex1","12","House Street","15", city);
        System.out.println(address);
        assertNotNull(address);
    }

    @Test public void buildWithError() {
        Country country = CountryFactory.build("3659","South Africa");
        City city = CityFactory.build("1985","Cape Town", country);
        Exception error = assertThrows(IllegalArgumentException.class, () ->
                AddressFactory.build(null,"Complex1","12","House Street","15", city));
        String ExceptionMessage = error.getMessage();
        System.out.println(error);
        assertSame("Unit Number required!", ExceptionMessage);
    }
}