/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Repository.Employee.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.Employee.EmployeeAddress;


@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
}
