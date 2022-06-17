// Marvin Hope - 219445842
// EmployeeFactoryTest.java
// 10 June 2022

package za.ac.cput.School_Management.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test public void buildWithSuccess() {
        Name name = NameFactory.build("John","Peter","Doe");
        Employee employee = EmployeeFactory.build("34hf","johndoe007@gmail.com", name );
        System.out.println(employee);
        assertNotNull(employee);
    }

    @Test public void buildWithError() {
        Name name = NameFactory.build("John","Peter","Doe");
        Exception error = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build(null, "johndoe007@gmail.com", name));
        String ExceptionMessage = error.getMessage();
        System.out.println(error);
        assertSame("Staff Id required!", ExceptionMessage);
    }
}