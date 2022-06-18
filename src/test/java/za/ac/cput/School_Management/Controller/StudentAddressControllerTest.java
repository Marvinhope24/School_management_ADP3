/* StudentAddressControllerTest.java
   Controller Testing for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.School_Management.Domain.*;
import za.ac.cput.School_Management.Factory.AddressFactory;
import za.ac.cput.School_Management.Factory.CityFactory;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Factory.StudentAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private StudentAddress studentAddress;
    private Address address;
    private City city;
    private Country country;
    private String baseURL;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.country = CountryFactory.build("23", "South Africa");
        this.city = CityFactory.build("12", "Cape Town", country);
        this.address = AddressFactory.build("204", "Prime", "13", "Angle Way", "3256", city);
        this.studentAddress = StudentAddressFactory.build("123456789", address);
        this.baseURL = "http://localhost: " + this.port +"school-management/studentAddress";
    }

    @Test
    @Order(1)
    void save()
    {
        String URL = baseURL + "/save";
        System.out.println(URL);
        ResponseEntity<StudentAddress> response = this.restTemplate.postForEntity(URL, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String URL = baseURL + "/read/" + this.studentAddress.getStudentId();
        System.out.println(URL);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(URL,StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete()
    {
        String URL = baseURL + "delete/" + this.studentAddress.getStudentId();
        this.restTemplate.delete(URL);
    }

    @Test
    @Order(4)
    void findAll()
    {
        String URL = baseURL + "/all";
        System.out.println(URL);
        ResponseEntity<StudentAddress[]> response =
                this.restTemplate.getForEntity(URL, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0 )
        );
    }
}
