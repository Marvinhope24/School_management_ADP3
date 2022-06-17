// Marvin Hope - 219445842
// EmployeeFactory.java
// 10 June 2022

package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Helper.StringHelper;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, Name name) {

        StringHelper.isEmptyOrNull("staffId");
        StringHelper.isEmptyOrNull("email");
        StringHelper.isEmptyOrNull("name");

        StringHelper.checkStringParam("Staff ID", staffId);
        StringHelper.checkStringParam("Email", email);

        StringHelper.ValidateEmail("marvinhope000@gmail.com",  "^\\S+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

        return new Employee.Builder().staffId(staffId).Email(email).Name(name).build();
    }
}
