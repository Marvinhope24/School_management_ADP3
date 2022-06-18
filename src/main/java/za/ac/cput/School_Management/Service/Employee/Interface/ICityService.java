/*  Kegomoditswe Leshope - 219189048
    ICityService.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Interface;

import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Service.IService;

import java.util.List;

public interface ICityService extends IService<City, String> {
    List<City> findAll();
   // void deleteById (String id);
}
