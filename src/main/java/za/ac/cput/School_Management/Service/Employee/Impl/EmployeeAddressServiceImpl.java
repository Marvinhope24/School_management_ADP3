/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import za.ac.cput.School_Management.Domain.EmployeeAddress;
import za.ac.cput.School_Management.Repository.Interface.EmployeeAddressRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService{

    private final EmployeeAddressRepository repository;

    @Autowired public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeAddress> findAll(){
        return this.repository.findAll();
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress){
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s){
        return this.repository.findById(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress){
        this.repository.delete(employeeAddress);
    }

}


