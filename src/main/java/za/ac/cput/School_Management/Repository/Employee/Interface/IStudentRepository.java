/*
Tiffany Kiwiets - 219322732
IStudentRepository.java
17 June 2022
 */

package za.ac.cput.School_Management.Repository.Employee.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.Employee.Student;

@Repository
public interface IStudentRepository extends JpaRepository < Student, String > {

}
