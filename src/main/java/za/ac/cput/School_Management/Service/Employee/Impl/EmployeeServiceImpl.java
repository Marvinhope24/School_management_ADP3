// Marvin Hope -219445842
// EmployeeServiceImpl.java
// 09 June 2022

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Repository.Interface.IEmployeeRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository repository;

    @Autowired public EmployeeServiceImpl(IEmployeeRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }
    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }
    @Override
    public Optional<Employee> read(String s) {
        return this.repository.findById(s);
    }
    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }
}

