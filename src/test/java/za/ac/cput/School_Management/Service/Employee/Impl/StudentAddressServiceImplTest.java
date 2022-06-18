/* StudentAddressServiceImplTest.java
   Service Implementation Testing for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.StudentAddress;
import za.ac.cput.School_Management.Factory.AddressFactory;
import za.ac.cput.School_Management.Factory.CityFactory;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Factory.StudentAddressFactory;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentAddressServiceImplTest
{
    private StudentAddress studentAddress;
    private Address address;
    private City city;
    private Country country;

    @Autowired
    private IStudentAddressService service;

    @BeforeEach
    void setUp()
    {
        this.country = CountryFactory.build("23", "South Africa");
        this.city = CityFactory.build("12", "Cape Town", country);
        this.address = AddressFactory.build("204", "Prime", "13", "Angle Way", "3256", city);
        this.studentAddress = StudentAddressFactory.build("123456789", address);
        StudentAddress saved = this.service.save(this.studentAddress);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.studentAddress, saved)
        );
    }

    @AfterEach
    void tearDown()
    {
        this.service.delete(this.studentAddress);
    }

    @Test
    void findAll()
    {
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(1, studentAddressList.size());
    }

    @Test
    void save()
    {
        StudentAddress saved = this.service.save(this.studentAddress);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.studentAddress, saved);
    }

    @Test
    void read()
    {
        Optional<StudentAddress> read = this.service.read(this.studentAddress.getStudentId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.studentAddress, read.get())
        );
    }

    @Test
    void delete()
    {
        StudentAddress delete = this.service.save(this.studentAddress);
        List<StudentAddress> studentAddressList = this.service.findAll();
        assertEquals(1, studentAddressList.size());
        this.service.delete(delete);
    }
}
