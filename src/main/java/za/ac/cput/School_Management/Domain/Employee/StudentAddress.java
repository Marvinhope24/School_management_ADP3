/* StudentAddress.java
   Entity for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Domain.Employee;

import org.apache.tomcat.jni.Address;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress
{
    // constructors
    @NotNull @Id private String studentId;
    @NotNull private String address;

    protected StudentAddress() {

    }

    // getters
    public String getStudentId() {
        return studentId;
    }

    public String getAddress() {
        return address;
    }

    // private constructors
    private StudentAddress (Builder builder)
    {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    // builder pattern
    public static class Builder
    {
        private String studentId;
        private String address;

        public StudentAddress.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder address(String address) {
            this.address = address;
            return this;
        }

        // builder copy
        public Builder copy(StudentAddress studentAddress)
        {
            this.studentId = studentAddress.getStudentId();
            this.address = studentAddress.getAddress();
            return this;
        }

        public StudentAddress build()
        {
            return new StudentAddress(this);
        }
    }

    public static class StudentAddressId //implements Serializable
    {
        private String studentId;

        public StudentAddressId(String studentId)
        {
            this.studentId = studentId;
        }

        public String getStudentId()
        {
            return studentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentAddressId that = (StudentAddressId) o;
            return Objects.equals(studentId, that.studentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId);
        }
    }

    // toString
    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }
}
