package za.ac.cput.School_Management.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {


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