// Marvin Hope -219445842
// IEmployeeRepository.java
// 16 June 2022
package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository <Employee, String> {
}