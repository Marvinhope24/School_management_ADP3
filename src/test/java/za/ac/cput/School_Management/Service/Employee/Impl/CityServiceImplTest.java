/*  Kegomoditswe Leshope - 219189048
    CityServiceImplTest.java
    10 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Factory.CityFactory;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Service.Employee.Interface.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceImplTest {
    private City city;
    private Country country;
    @Autowired
    private ICityService service;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.build("7945","South Africa");
        this.city = CityFactory.build("345","Cape Town", country);
        City saved = this.service.save(this.city);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.city, saved)
        );
    }
    @Test
    void findAll() {
        List<City> CityList = this.service.findAll();
        System.out.println(CityList);
        assertEquals(1,CityList.size());
    }

    @Test
    void save() {
        City save = this.service.save(this.city);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    void read() {
        Optional<City> read = this.service.read(this.city.getCityId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city, read.get())
        );
    }

    @Test
    void delete() {
        City  delete = this.service.save(this.city);
        List<City> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
        this.service.delete(delete);
    }
}