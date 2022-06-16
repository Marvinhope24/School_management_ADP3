package za.ac.cput.School_Management.Repository.Employee.Interface;

import za.ac.cput.School_Management.Domain.Employee.Name;

import java.util.Optional;

public interface iNameRepo<T, S> {
    public T save(T t);
    public <ID> Optional<T> read(ID id);
    public void delete(Name t);

    Optional<Name> read(String identity);
}