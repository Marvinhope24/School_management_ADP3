package za.ac.cput.School_Management.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Factory.CountryFactory;
import za.ac.cput.School_Management.Service.Employee.Interface.ICountryService;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class CountryAPITest {
    private Country country = CountryFactory.build("7945", "South Africa");
    @Autowired private CountryAPI api;
    //private Country country;

    @Test
    void read() {
        Optional<Country> read = this.api.read(this.country.getCountryId());
        assertNotNull(read);
    }
}