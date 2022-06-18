package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;
import java.util.Optional;

public interface INameService <S,s>{
    S save(S s);
    Optional<S> read (S S);
    void delete (S s);

    List<Name> findAll();

    Name save(Name name);

    Optional<Name> read(String s);

    void delete(Name name);
}

