/* StudentAddress.java
   Entity for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Domain;

import za.ac.cput.School_Management.Domain.Address;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress implements Serializable {
    // constructors
    @Id @NotNull  private String studentId;
    @Embedded private Address address;

    public StudentAddress() {

    }

    // getters
    public String getStudentId() {return studentId;}
    public Address getAddress() {return address;}

    private StudentAddress (Builder builder)
    {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentAddress)) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId.equals(that.studentId) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, address);
    }

    // toString
    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    // builder pattern
    public static class Builder
    {
        private String studentId;
        private Address address;

        public StudentAddress.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder address(Address address) {
            this.address = address;
            return this;
        }

        // builder copy
        public Builder copy(StudentAddress studentAddress)
        {
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build()
        {
            return new StudentAddress(this);
        }
    }
}


