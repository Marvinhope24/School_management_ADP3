package za.ac.cput.School_Management.Service.Employee.Impl;

import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Service.Employee.Interface.INameService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface NameService extends INameService<Name, String> {


   List<Name> find();
}
