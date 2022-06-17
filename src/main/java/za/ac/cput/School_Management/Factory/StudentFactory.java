/*
Tiffany Kiwiets - 219322732
StudentFactory.java
16 June 2022
 */

package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Domain.Name;
import za.ac.cput.School_Management.Helper.StringHelper;

public class StudentFactory {

    public static Student build(String studentId, String email, Name name) {

        StringHelper.isEmptyOrNull("studentId");
        StringHelper.isEmptyOrNull("email");
        StringHelper.isEmptyOrNull("name");

        StringHelper.checkStringParam("Student ID", studentId);
        StringHelper.checkStringParam("Email", email);

        return new Student.Builder().studentId(studentId).email(email).name(name).build();

    }
}
