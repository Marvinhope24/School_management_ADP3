/*
Tiffany Kiwiets - 219322732
IStudentService.java
17 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;

public interface IStudentService extends IService<Student, String> {
    List <Student> findAll();

}
