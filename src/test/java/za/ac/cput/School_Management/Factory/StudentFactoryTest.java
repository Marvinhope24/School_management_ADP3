/*
Tiffany Kiwiets - 219322732
StudentFactoryTest.java
16 June 2022
 */

package za.ac.cput.School_Management.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Domain.Name;
import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest {

    @Test public void buildWithSuccess() {
        Name name = NameFactory.build("Nicki", "Cardi", "Jhene");
        Student student = StudentFactory.build("ten10", "nickicardi10@gmail.com", name);
        System.out.println(student);
        assertNotNull(student);
    }

    @Test public void buildWithError() {
        Name name = NameFactory.build("Nicki", "Cardi", "Jhene");
        Exception err = assertThrows(IllegalArgumentException.class, () -> StudentFactory.build(null, "nickicardi10@gmail.com", name));
        String ExceptionMessage = err.getMessage();
        System.out.println(err);
        assertSame("Student ID is required.", ExceptionMessage);
    }
}
