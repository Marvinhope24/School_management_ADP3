/*  Kegomoditswe Leshope - 219189048
    CountryAPI.java
    17 June 2022
 */

package za.ac.cput.School_Management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Service.Employee.Interface.ICountryService;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import java.util.Optional;

@Component
public class CountryAPI {

    private final ICountryService iCountryService;
    private final IStudentService iStudentService;


    public CountryAPI(ICountryService iCountryService,
                      IStudentService iStudentService) {
        this.iCountryService = iCountryService;
        this.iStudentService = iStudentService;
    }

    public Country read(Country country, Student student) {
        this.iStudentService.read(student.getStudentId());
        return null;
    }

    public Optional<Country> read(String countryId) {
        return null;
    }
}



