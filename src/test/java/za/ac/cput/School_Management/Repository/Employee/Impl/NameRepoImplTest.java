package za.ac.cput.School_Management.Repository.Employee.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Factory.Employee.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

class NameRepoImplTest {

    private static NameRepoImpl NameRepo = (NameRepoImpl) NameRepoImpl.getRepository();
    private static Name name = NameFactory.build("Siyabonga","tumelo", "Masango");

    @Test
    void a_create() {
        Name NameCreated = NameRepo.create(name);
        assertEquals(name.getFirstName(), NameCreated.getFirstName());
        System.out.println("Created: " + NameCreated);
    }

    @Test
    public void b_read() {
        NameRepoImpl repo = new NameRepoImpl();
        Name testName = new Name.Builder().firstName(name.getFirstName()).build();
        Assertions.assertNotNull(repo.read(testName));
    }


    @Test
    void c_delete() {
        boolean outcome = NameRepo.delete(name.getFirstName());
        assertFalse(outcome);
        System.out.println("Deleted: " + true);
    }


    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(NameRepo.getAll());
        System.out.println(name);
    }

}