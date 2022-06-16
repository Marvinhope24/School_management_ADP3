package za.ac.cput.School_Management.Factory.Employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test
    public void buildWithNullNameAndSuccess(){
        Name name = NameFactory.build("tumelo",null, "masango");
        assertAll(
                ()-> assertTrue(name.getMiddleName().isEmpty()),
                ()-> assertNotNull(name)
        );
        assertTrue(name.getMiddleName().isEmpty());
        System.out.println(name);
    }

    @Test
    public void buildWithCompletedValues(){
        Name n = NameFactory.build("tumelo", "siyabonga", "masango");
        System.out.println(n);
        assertNotNull(n);
    }

    @Test
    public void buildError(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                NameFactory.build("tumelo","siyabonga","Masango"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }


}