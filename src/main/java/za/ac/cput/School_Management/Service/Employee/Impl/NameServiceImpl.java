package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Service.Employee.Interface.INameService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
public class NameServiceImpl implements INameService {
    private final INameService repository;

    @Autowired
    public  NameServiceImpl(INameService repository){
        this.repository = repository;
    }

    public static NameService getService() {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Optional read(Object S) {
        return Optional.empty();
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public List<Name> findAll() {
        return this.repository.findAll();
    }
    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(String s) {
        return Optional.empty();
    }
    // @Override
   // public Optional<Name> read(String s) {
       // return this.repository.findAll(s);
    //}
    @Override
    public void delete(Name name) {
        this.repository.delete(name);
    }
}

