package za.ac.cput.School_Management.Service;

import java.util.Optional;

public interface IService <T,ID> {
    T save(T t);
    Optional<T> read (ID id);
    void delete (T t);
}
