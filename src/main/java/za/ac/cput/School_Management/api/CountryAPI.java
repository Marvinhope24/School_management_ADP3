/*  Kegomoditswe Leshope - 219189048
    CountryAPI.java
    17 June 2022
 */

package za.ac.cput.School_Management.api;

import org.springframework.stereotype.Component;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Service.Employee.Interface.ICountryService;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import java.util.Optional;

@Component
public class CountryAPI {
   /* private final ICountryService iCountryService;
    private final IStudentService iStudentService;


    public CountryAPI(ICountryService iCountryService,
                      IStudentService iStudentService) {
        this.iCountryService = iCountryService;
        this.iStudentService = iStudentService;
    }

    public Country read (Country country, Student student){

        Optional<Student> read = this.iStudentService.read(student.getName());
        if (read.isPresent(){

            Optional<Country> country =
                    this.iCountryService.read(country.getCountryId);
            if(country.isPresent()){
                return this.iCountryService.save(country);
            } return null;

            return null;
        }


    }*/
}
