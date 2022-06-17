// Marvin Hope - 219445842
// EmployeeServiceImplTest.java
//17 June 2022

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Factory.EmployeeFactory;
import za.ac.cput.School_Management.Factory.NameFactory;
import za.ac.cput.School_Management.Service.Employee.Interface.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {
    private Employee employee;
    private Name name;
    @Autowired private IEmployeeService service;

    @BeforeEach
    void setUp() {
        this.name = NameFactory.build("John","Peter","Doe");
        this.employee = EmployeeFactory.build("23ght","johndoe007@gmail.com", name);
        Employee saved = this.service.save(this.employee);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.employee, saved)
        );
    }
    @Test
    void findAll() {
        List<Employee> employeeList = this.service.findAll();
        System.out.println(employeeList);
        assertEquals(1,employeeList.size());
    }

    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        System.out.println(saved);
        assertNotNull(saved);
    }

    @Test
    void read() {
        Optional<Employee> read = this.service.read(this.employee.getStaffId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.employee, read.get())
        );
    }

    @Test
    void delete() {
        Employee delete = this.service.save(this.employee);
        List<Employee> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
        this.service.delete(delete);
    }
}