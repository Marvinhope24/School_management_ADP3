package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.School_Management.Domain.Name;

import java.util.Optional;

public interface iNameRepo<T, S> {
    public T save(T t);
    public <ID> Optional<T> read(ID id);
    public void delete(Name t);

    Optional<Name> read(String identity);
}
