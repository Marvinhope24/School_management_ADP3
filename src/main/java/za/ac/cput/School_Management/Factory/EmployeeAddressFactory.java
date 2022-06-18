/*Jayden Johnson -219086796
 EmployeeAddressFactory.java
 */

package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.EmployeeAddress;
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
