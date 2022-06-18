/*  Kegomoditswe Leshope - 219189048
    CityServiceImplTest.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Factory.CityFactory;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Repository.Interface.ICityRepository;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceImplTest {
    private City city;
    private Country country;
    @Autowired private CityServiceImpl service;
    @Autowired private ICityRepository repository;

    @BeforeEach
    void setUp(){
        this.city = CityFactory.build("CPT","Cape Town", city.getCountry());
        this.country = CountryFactory.build("ZA", "South Africa");
        City saved = this.service.save(this.city);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertSame (this.city, saved)
        );
    }


    @AfterEach
    void tearDown() {
        this.service.delete(this.city);
    }


    @Test
    void read() {
        Optional<City> read = this.service.read(this.city.getCityId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.city,read.get())
        );
    }

    @Test
    void findAll() {
        List<City> cityList =
                this.service.findAll();
        System.out.println(city);
        assertSame(1, cityList.size());
    }

    @Test
    void findById(String countryId){
        this.service.findById(countryId);
        assertSame(this.city.getCountry().getCountryId(),countryId);
    }

 /*   @Order(1)
//    @Test
//    void getCityService() {
//        cityService = CityServiceImpl.getCityService();
//    }

    @Order(2)
    @Test
    void save() throws Exception {
        Country country = CountryFactory.getCountry("0001","South Africa");
        Country savedCountry = countryRepository.save(country);
        System.out.println("savedCountry");
        System.out.println(savedCountry);
        City mycity = CityFactory.getCity("1234","Pretoria",savedCountry);
        System.out.println(mycity);
        City city = cityService.save(mycity);
        assertNotNull(city);
    }

    @Order(3)
    @Test
    void read() {
        City city = cityService.read("1234").get();
        System.out.println(city);
        assertNotNull(city);
    }
    @Order(4)
    @Test
    void update() throws Exception {
        Country country = CountryFactory.getCountry("0001","South Africa");
        City city = cityService.update(CityFactory.getCity("1234","Pretoria",country));
        assertNotNull(city);
    }
    @Order(5)
    @Test
    void delete() throws Exception {
        Country country = CountryFactory.getCountry("0001","South Africa");
        City cityObject = CityFactory.getCity("1234","Pretoria",country);
        cityService.delete(cityObject);
        City city = cityService.read("1234").orElse(null);
        assertNull(city);
    }

    @Order(6)
    @Test
    void readAll() {
        List<City> cities = cityService.readAll();
        assertNotNull(cities);
    }
}*/
}