/*Jayden Johnson -219086796
 EmployeeAddressControllerTest.java
 */

package za.ac.cput.School_Management.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.EmployeeAddress;
import za.ac.cput.School_Management.Factory.AddressFactory;
import za.ac.cput.School_Management.Factory.CityFactory;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Factory.EmployeeAddressFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private Country country;
    private City city;
    private Address address;
    private  String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.country = CountryFactory.build("3659","South Africa");
        this.city = CityFactory.build("1985","Cape Town", country);
        this.address = AddressFactory.build("354","Complex1","12","House Street","15", city);
        this.employeeAddress = EmployeeAddressFactory.build("36525",address);
        this.baseUrl = "http://localhost:" + this.port +"/payroll/employee-address/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate
                .postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate.getForEntity(url,EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.employeeAddress.getStaffId();
        this.restTemplate.delete(url);

    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response =
                this.restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length == 0)
        );

    }
}

