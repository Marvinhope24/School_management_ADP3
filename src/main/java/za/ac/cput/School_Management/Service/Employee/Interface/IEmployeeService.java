// Marvin Hope -219445842
// Employee.java
// 09 June 2022

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;

public interface IEmployeeService extends IService <Employee, String> {
    List<Employee> findAll();
}
