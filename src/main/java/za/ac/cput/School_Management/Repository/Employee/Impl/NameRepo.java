package za.ac.cput.School_Management.Repository.Employee.Impl;

import za.ac.cput.School_Management.Domain.Employee.Name;
import za.ac.cput.School_Management.Repository.Employee.Interface.iNameRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class NameRepo implements iNameRepo<Name, String> {
    private static List<Name> nameList;
    private static NameRepo Repo = null;


    NameRepo() {
        nameList = new ArrayList<>();
    }

    public static NameRepo repository(){
        if(Repo == null){
            Repo = new NameRepo() {
                @Override
                public Name create(Name name) {
                    return null;
                }

                @Override
                public Name update(Name name) {
                    return this.update(name);
                }

                @Override
                public Set<Name> getAll() {
                    return this.getall();
                }

                @Override
                public Set<Name> getall() {
                    return this.getall();
                }
            };
        }
        return Repo;
    }

    public boolean delete(String firstName) {
        return false;
    }

    public Name save(Name name) {
        Optional<Name> read = read(name.getFirstName());

        if (read.isPresent()) {
            delete(read.get());
        }

        this.nameList.add(name);
        return name;
    }

    @Override
    public <ID> Optional<Name> read(ID id) {
        return Optional.empty();
    }



    public abstract Name create(Name name);

    public abstract Name update(Name name);

    @Override
    public Optional<Name> read(String identity) {
        return this.nameList
                .stream()
                .filter(g -> g.getFirstName().equalsIgnoreCase(identity))
                .filter(g -> g.getMiddleName().equalsIgnoreCase(identity))
                .filter(g-> g.getLastName().equalsIgnoreCase(identity))
                .findFirst();
    }

    public void delete(Name name){
        nameList.remove(name);
    }

    public List<Name> findByFirstName(Name name){
        return this.nameList
                .stream()
                .filter(g -> g.getFirstName().equalsIgnoreCase(name.getFirstName()))
                .collect(Collectors.toList());
    }


    public abstract Set<Name> getAll();

    public abstract Set<Name> getall();
}
