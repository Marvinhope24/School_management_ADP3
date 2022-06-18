/* StudentAddressServiceImpl.java
   Service Implementation class for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.School_Management.Domain.StudentAddress;
import za.ac.cput.School_Management.Repository.Interface.IStudentAddressRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements IStudentAddressService
{
    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(IStudentAddressRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<StudentAddress> findAll()
    {
        return this.repository.findAll();
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress)
    {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s)
    {
        return this.repository.findById(s);
    }

    @Override
    public void delete(StudentAddress studentAddress)
    {
        this.repository.delete(studentAddress);
    }
}


