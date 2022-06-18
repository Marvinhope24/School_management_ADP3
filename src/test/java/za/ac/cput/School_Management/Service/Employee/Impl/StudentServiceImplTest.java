/*
Tiffany Kiwiets - 219322732
StudentServiceImplTest.java
17 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Factory.NameFactory;
import za.ac.cput.School_Management.Factory.StudentFactory;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplTest {
    private Name name;
    private Student student;
    @Autowired private IStudentService service;

    @BeforeEach
    void setUp() {
        this.name = NameFactory.build("Nick", "Cardi", "Jhene");
        this.student = StudentFactory.build("ten10", "nickicardi10@gmail.com", name);
        Student saved = this.service.save(this.student);
        assertAll (
                () -> assertNotNull(saved),
                () -> assertEquals(this.student, saved)
        );
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.student);
    }

    @Test
    void findAll() {
        List <Student> studentList = this.service.findAll();
        assertEquals(1, studentList.size());
    }

    @Test
    void save() {
        Student saved = this.service.save(this.student);
        System.out.println(saved);
        assertNotNull(saved);

    }

    @Test
    void read() {
        Optional <Student> read = this.service.read(this.student.getStudentId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student, read.get())
        );
    }

    @Test
    void delete() {
        Student delete = this.service.save(this.student);
        List <Student> studentList = this.service.findAll();
        assertEquals(1, studentList.size());
        this.service.delete(delete);
    }

}
