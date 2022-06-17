/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Domain;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class EmployeeAddress  {
    @NotNull @Id private String staffId;
    @Embedded private Address address;

    protected EmployeeAddress() {}

    private EmployeeAddress(Builder builder){
        this.staffId = builder.staffId;
        this.address = builder.address;

    }
    public String getStaffId() {return staffId;}

    public Address getAddress() {return address;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EmployeeAddress employeeAddress = (EmployeeAddress) o;
        return staffId.equals(employeeAddress.staffId) && address.equals(employeeAddress.address);
    }

    @Override
    public int hashCode(){return Objects.hash(staffId, address);}

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String staffId;
        private Address address;

        public EmployeeAddress.Builder staffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public EmployeeAddress.Builder address (Address address){
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress){
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;
            return this;
        }

        public EmployeeAddress build() { return new EmployeeAddress(this);}
    }

}


