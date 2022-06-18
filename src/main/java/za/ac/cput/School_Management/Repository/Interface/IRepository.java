package za.ac.cput.School_Management.Repository.Interface;

import java.util.Optional;

public interface IRepository <T, ID> {
    T save (T t);
    Optional<T> read (ID id);
    void delete(T t);
}
