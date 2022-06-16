package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Employee.Name;

import java.util.Optional;

public interface INameService<T, ID> {
    public T save(T t);

    public <ID> Optional<T> read(ID id);

    public Name delete(T t);

    Name create(T t);

    Name update(T t);

}

