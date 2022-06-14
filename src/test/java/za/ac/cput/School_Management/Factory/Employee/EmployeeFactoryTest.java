// Marvin Hope - 219445842
// EmployeeFactoryTest.java
// 10 June 2022

package za.ac.cput.School_Management.Factory.Employee;
import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Employee;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test public void buildWithSuccess() {
        Employee employee = EmployeeFactory.build("2fr457","johndoe007@gmail.com","John Doe");
        System.out.println(employee);
        assertNotNull(employee);
    }

    @Test public void buildWithError() {
        Exception error = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build(null, "johndoe007@gmail.com", "John Doe"));
        String ExceptionMessage = error.getMessage();
        System.out.println(error);
        assertSame("Staff Id required!", ExceptionMessage);
    }
}