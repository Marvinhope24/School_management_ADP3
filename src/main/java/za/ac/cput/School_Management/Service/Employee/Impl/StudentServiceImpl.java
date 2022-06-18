/*
Tiffany Kiwiets - 219322732
StudentServiceImpl.java
17 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Repository.Interface.IStudentRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository repository;
    @Autowired public StudentServiceImpl(IStudentRepository repository){
        this.repository = repository;
    }

    @Override
    public List <Student> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Student save (Student student) {
        return this.repository.save (student);
    }

    @Override
    public Optional <Student> read (String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete (Student student) {
        this.repository.delete(student);
    }

}
