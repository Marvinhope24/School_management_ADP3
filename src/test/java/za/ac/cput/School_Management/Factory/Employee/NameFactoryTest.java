package za.ac.cput.School_Management.Factory.Employee;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Service.Employee.Impl.NameServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test

    public void createFirstNames(){
        Name nam = NameFactory.build("Siyabonga","Tumelo","Masango");
        System.out.println("Name of this system: "+nam.getFirstName());
        assertEquals("Siyabonga",nam.getFirstName());
    }

    @Test

    public void createMiddleName(){
        Name nam = NameFactory.build("Siyabonga", null, "Masango");
        assertNull(nam.getMiddleName());
    }


    @Test

    public void createLastName(){
        Name nam = NameFactory.build("Siyabonga","Sean","Masango");
        System.out.println("Lastname of this system: "+nam.getLastName());
        assertSame("Masango",nam.getLastName());
    }

    @Disabled("CreateName disabled")
    @Test
    //We disabling the test
    public void createName(){
        Name nam = (Name) NameServiceImpl.getService().getAll();
        assertSame("Siyabonga",nam.getFirstName());
    }


}