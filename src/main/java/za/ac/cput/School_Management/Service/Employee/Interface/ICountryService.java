/*  Kegomoditswe Leshope - 219189048
    ICountryService.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;
import java.util.Optional;

public interface ICountryService extends IService <Country, String> {
    List<Country> findAll();

    //Optional<Country> findById(String id);
    //List<Country> deleteById(String id);

}
