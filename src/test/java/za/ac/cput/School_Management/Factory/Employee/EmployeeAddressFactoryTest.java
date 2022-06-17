/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Factory.Employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Address;
import za.ac.cput.School_Management.Domain.Employee.City;
import za.ac.cput.School_Management.Domain.Employee.Country;
import za.ac.cput.School_Management.Domain.Employee.EmployeeAddress;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeAddressFactoryTest {

    @Test
    public void buildWithSuccess() {
        Country country = CountryFactory.build("3659","South Africa");
        City city = CityFactory.build("1985","Cape Town", country);
        Address address = AddressFactory.build("354","Complex1","12","House Street","15", city);
        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("369856", address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test public void buildWithError(){
        Country country = CountryFactory.build("3659","South Africa");
        City city = CityFactory.build("1985","Cape Town", country);
        Address address = AddressFactory.build("354","Complex1","12","House Street","15", city);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> EmployeeAddressFactory.build(null, address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("staff ID is required!", exceptionMessage);
    }
}
