package za.ac.cput.School_Management.Service.Employee.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.Name;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NameImplTest {
    private Name name;
    @Autowired private NameImplTest service;

    private Name Name;


    @Test
    za.ac.cput.School_Management.Domain.Name save(za.ac.cput.School_Management.Domain.Name name)
    {
       Name saved = this.service.save(this.name);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.Name, saved)
        );
        return saved;
    }

    @Test
    Optional<Name> read(String firstName) {
        Optional<Name> read = this.service.read(this.name.getFirstName());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.name, read.get())
        );
        return read;
    }

    @Test
    void delete(Name name) {
        this.service.delete(this.name);
    }

    @Test
    List<Name> findAll() {
        List<Name> NameList = this.service.findAll();
        assertSame(0, NameList);
        return NameList;
    }
}