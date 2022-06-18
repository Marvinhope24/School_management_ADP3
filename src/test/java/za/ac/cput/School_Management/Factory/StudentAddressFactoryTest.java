/* StudentAddressFactoryTest.java
   Factory Testing for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/
package za.ac.cput.School_Management.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

    @Test
    public void buildWithSuccess()
    {
        Country country = CountryFactory.build("23", "South Africa");
        City city = CityFactory.build("12", "Cape Town", country);
        Address address = AddressFactory.build("204", "Prime", "13", "Angle Way", "3256", city);
        StudentAddress studentAddress = StudentAddressFactory.build("123456789", address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    public void buildWithError()
    {
        Country country = CountryFactory.build("23", "South Africa");
        City city = CityFactory.build("12", "Cape Town", country);
        Address address = AddressFactory.build("204", "Prime", "13", "Angle Way", "3256", city);
        Exception error = assertThrows(IllegalArgumentException.class, ()->
                StudentAddressFactory.build(null, address));
        String ExceptionMessage = error.getMessage();
        System.out.println(error);
        assertSame("Student ID required", ExceptionMessage);
    }
}

