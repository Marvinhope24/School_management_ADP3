package za.ac.cput.School_Management.Repository.Employee.Impl;

import za.ac.cput.School_Management.Domain.Employee.Name;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class NameRepoImpl extends NameRepo {

    private Set<Name> Names;
    private static NameRepo repo1 = null;

    public NameRepoImpl() {
        this.Names = new HashSet<>();
    }

    public static  NameRepo getRepository() {
        if (repo1 == null) repo1 = new NameRepoImpl ();
        return repo1;
    }

    @Override
    public Name create(Name name) {
        this.Names.add(name);
        return name;
    }

    @Override
    public Name update(Name name) {
        Optional<Name> read = read(name.getFirstName());
        if (read != null) {
            this.Names.remove(read);
            this.Names.add(name);
            return name;
        }
        return null;
    }

    @Override
    public Optional<Name> read(String s) {
        for (Name name : this.Names) {
            if (name.getLastName().equalsIgnoreCase(name.getLastName())) return Optional.of(name);
        }
        return null;
    }

    @Override
    public Set<Name> getAll() {
        return this.Names;
    }

    @Override
    public boolean delete(String s) {
        Optional<Name> name = read(s);
        if (name != null) this.Names.remove(name);
        return false;
    }

    @Override
    public Set<Name> getall() {
        return this.Names;
    }



}
