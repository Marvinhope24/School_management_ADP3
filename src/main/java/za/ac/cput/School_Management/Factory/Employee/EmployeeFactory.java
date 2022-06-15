// Marvin Hope - 219445842
// EmployeeFactory.java
// 10 June 2022

package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Employee;
import za.ac.cput.School_Management.Helper.StringHelper;

public class EmployeeFactory {
    public static Employee build(String staffId, String email, String name) {

        StringHelper.isEmptyOrNull("staffId");
        StringHelper.isEmptyOrNull("email");
        StringHelper.isEmptyOrNull("name");

        StringHelper.checkStringParam("Staff ID", staffId);
        StringHelper.checkStringParam("Email", email);
        StringHelper.checkStringParam("Name", name);

        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
    public static Employee.Builder.StaffId build(Employee employee) {
        return new Employee.Builder.StaffId (employee.getStaffId());

    }
}
