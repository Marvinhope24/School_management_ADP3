/*Jayden Johnson -219086796
 EmployeeAddressRepository.java
 */

package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.EmployeeAddress;


@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
}
