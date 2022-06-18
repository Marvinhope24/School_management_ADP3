/*  Kegomoditswe Leshope - 219189048
    ICityRepository.java
    13 June 2022
 */

package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.School_Management.Domain.City;


@Repository
public interface ICityRepository extends JpaRepository <City, String> {
}
