/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Service.Employee.Interface.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAddressServiceImplTest {
    /*private EmployeeAddress employeeAddress;
    @Autowired private EmployeeAddressService service;

    @BeforeEach
    void setUp(){
        this.country = CountryFactory.build("3659","South Africa");
        this.city = CityFactory.build("1985","Cape Town", country);
        this.address = AddressFactory.build("354","Complex1","12","House Street","15", city);
        this.employeeAddress = EmployeeAddressFactory.build("23ght",address);
        EmployeeAddress saved = this.service.save(this.employeeAddress);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.employeeAddress, saved)
        );
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.employeeAddress);
    }

    @Test
    void findAll() {
        List<EmployeeAddress> employeeAddressList = this.service.findAll();
        assertEquals(1,employeeAddressList.size());
    }

    @Test
    void deleteByID() {
    }

    @Test
    void save() {
        EmployeeAddress saved = this.service.save(this.employeeAddress);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employeeAddress, saved);
    }

    @Test
    void read() {
        Optional<EmployeeAddress> read = this.service.read(this.employeeAddress.getStaffId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employeeAddress, read.get())
        );
    }

    @Test
    void delete() {
        EmployeeAddress delete = this.service.save(this.employeeAddress);
        List<EmployeeAddress> employeeAddressList = this.service.findAll();
        assertEquals(1,employeeAddressList.size());
        this.service.delete(delete);
    }*/
}
