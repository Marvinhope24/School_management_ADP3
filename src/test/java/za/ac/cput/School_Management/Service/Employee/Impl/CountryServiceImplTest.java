/*  Kegomoditswe Leshope - 219189048
    CountryServiceImplTest.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Repository.Interface.ICountryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CountryServiceImplTest {
    private Country country;
   @Autowired private CountryServiceImpl service;
   @Autowired private ICountryRepository countryRepository;

    @Test
    void save()
    {
        Country saved = this.service.save(this.country);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.country, saved)
        );
    }

    @Test
    void read() {
        Optional<Country> read = this.service.read(this.country.getCountryId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.country, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.country);
    }

    @Test
    void findAll() {
        List<Country> countryList = this.service.findAll();
        assertSame(0, countryList);
    }
}