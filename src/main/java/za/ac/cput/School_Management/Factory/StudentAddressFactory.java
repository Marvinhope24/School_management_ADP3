/* StudentAddressFactory.java
   Factory class for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.StudentAddress;
import za.ac.cput.School_Management.Helper.StringHelper;

public class StudentAddressFactory
{
    public static StudentAddress build(String studentId, Address address)
    {
        StringHelper.isEmptyOrNull("studentId");
        StringHelper.isEmptyOrNull("address");

        StringHelper.checkStringParam("Student ID", studentId);
        StringHelper.checkStringParam("Address", String.valueOf(address));

        return new StudentAddress.Builder()
                .studentId(studentId)
                .address(address)
                .build();
    }
}


