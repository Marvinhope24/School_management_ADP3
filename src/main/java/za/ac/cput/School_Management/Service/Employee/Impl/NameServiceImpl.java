package za.ac.cput.School_Management.Service.Employee.Impl;

import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Repository.Employee.Impl.NameRepo;
import za.ac.cput.School_Management.Repository.Employee.Impl.NameRepoImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class NameServiceImpl implements NameService {
    private NameRepo repository;
    private static NameService service = null;

    private NameServiceImpl() {
        this.repository = NameRepoImpl.getRepository();
    }

    public static NameService getService() {
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name save(Name name) {
        return (Name) this.repository.getall();
    }

    @Override
    public <ID> Optional<Name> read(ID id) {
        return Optional.empty();
    }

    @Override
    public Name delete(Name name) {
        repository.delete(name);
        return name;
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public Optional<Name> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Name> getall(Name name) {
        return this.repository.getall();
    }

    @Override
    public Name delete(String s) {
        repository.delete(s);
        return null;
    }

    @Override
    public Set<Name> getall() {
        return null;
    }


    @Override
    public Set<Name> getAll() {
        return this.repository.getall();
    }

    @Override
    public Set<Name> getWithLastName(String lastName) {
        Set<Name> names = getAll();
        Set<Name> result = new HashSet<>();
        for(Name name : names) {
            if (name.getLastName().equalsIgnoreCase(lastName)) {
                result.add(name);
            }
        }
        return result;
    }
}