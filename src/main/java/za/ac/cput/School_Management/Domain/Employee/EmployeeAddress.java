package za.ac.cput.School_Management.Domain.Employee;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(EmployeeAddress.EmployeeAddressId.class)
public class EmployeeAddress{

    @NotNull @Id  private String staffId;
    @NotNull private String address;

    protected EmployeeAddress() {}

    private EmployeeAddress(Builder builder){
        this.staffId = builder.staffId;
        this.address = builder.address;

    }

    public String getStaffId() {return staffId;}

    public String getAddress() {return address;}

    public static class Builder{
        private String staffId, address;

        public Builder staffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public Builder address (String address){
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

    public static class EmployeeAddressId implements Serializable {
        private String staffId;

        public EmployeeAddressId(String staffId){
            this.staffId = staffId;
        }

        protected EmployeeAddressId() {}

        public String getStaffId() {return staffId; }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            EmployeeAddressId that = (EmployeeAddressId) o;
            return staffId.equals(that.staffId);
        }

        @Override
        public int hashCode(){return Objects.hash(staffId);}

    }
}
