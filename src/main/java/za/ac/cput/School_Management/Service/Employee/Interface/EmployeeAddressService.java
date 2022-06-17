/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Employee.EmployeeAddress;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> findAll();
    void deleteByID(String id);
}
