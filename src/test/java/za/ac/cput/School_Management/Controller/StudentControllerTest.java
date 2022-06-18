/*
Tiffany Kiwiets - 219322732
StudentControllerTest.java
17 June 2022
 */

package za.ac.cput.School_Management.Controller;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Factory.NameFactory;
import za.ac.cput.School_Management.Factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private StudentController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Name name;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.build("Nicki", "Cardi", "Jhene");
        this.student = StudentFactory.build("ten10", "nickicardi10@gmail.com", name);
        this.baseUrl = "http://localhost: " + this.port + "school-management/student";
        }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.postForEntity(url, this.student, Student.class);
        System.out.println(response);
        assertAll (
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "/read/" + this.student.getStudentId();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.student.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        ResponseEntity<Student[]> response =
                this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0 )
        );
    }
}