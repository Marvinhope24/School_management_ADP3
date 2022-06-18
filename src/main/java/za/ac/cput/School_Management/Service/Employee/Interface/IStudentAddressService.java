/* IStudentAddressService.java
   Service Interface for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.StudentAddress;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;

public interface IStudentAddressService extends IService<StudentAddress, String>
{
    List<StudentAddress> findAll();
}


