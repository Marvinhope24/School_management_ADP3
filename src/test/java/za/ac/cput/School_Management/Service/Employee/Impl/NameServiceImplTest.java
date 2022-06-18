package za.ac.cput.School_Management.Service.Employee.Impl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Factory.Employee.NameFactory;
import za.ac.cput.School_Management.Repository.Employee.Impl.NameRepoImpl;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceImplTest {

    private static Name name = NameFactory.build("Siyabonga", "Tumi", "Masango");
    private NameService service = NameServiceImpl.getService();

    @Before("")
    public void setUp() {
        System.out.println("Name: " + name);
    }


    @Test
    public void b_read() {
        NameRepoImpl repo = new NameRepoImpl();
        Name testName = new Name.Builder().firstName(name.getFirstName()).build();
        Assertions.assertNotNull(repo.read(testName));
    }


    @Disabled("newName disabled")
    @Test
    //disabled
    public void creaName(){
        Name name = NameFactory.build("Masango","Masango","Masango");
        assertSame("Masango",name.getFirstName());
    }



    @Test
    public void a_create() {
        Name inserted = service.create(name);
        assertEquals(inserted.getFirstName(), name.getFirstName());
        System.out.println("Inserted: " + inserted);
    }



    @Test
    public void e_delete() {
        service.delete(name.getMiddleName());
    }


}