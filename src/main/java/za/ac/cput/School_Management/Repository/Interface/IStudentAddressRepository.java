/* IStudentAddressRepository.java
   Repository Interface for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.StudentAddress;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String>
{
}


