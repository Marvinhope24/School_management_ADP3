/*  Kegomoditswe Leshope - 219189048
    ICountryRepository.java
    13 June 2022
 */

package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.Student;


@Repository
public interface ICountryRepository extends JpaRepository<Country,String> {

    //select * from student where country_id= '';
    Student findByLastName(String studentLatName, String country);

}
