package za.ac.cput.School_Management.Service.Employee.Impl;

import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Service.Employee.Interface.INameService;

import java.util.Optional;
import java.util.Set;

public interface NameService extends INameService<Name, String> {


    Optional<Name> read(String s);

    Set<Name> getall(Name name);

    Set<Name> getAll();

    Name delete(String s);

    Set<Name> getall();

    Set<Name> getWithLastName(String lastName);
}

