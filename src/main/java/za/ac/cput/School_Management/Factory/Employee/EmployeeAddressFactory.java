/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Address;
import za.ac.cput.School_Management.Domain.Employee.EmployeeAddress;
import za.ac.cput.School_Management.Helper.StringHelper;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, Address address)  {

        StringHelper.isEmptyOrNull("staffId");
        StringHelper.isEmptyOrNull("address");

        StringHelper.checkStringParam("staffId", staffId);

        return new EmployeeAddress.Builder()
                .staffId(staffId)
                .address(address)
                .build();
    }

}
