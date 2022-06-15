// Marvin Hope -219445842
// Employee.java
// 09 June 2022

package za.ac.cput.School_Management.Domain.Employee;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
public class Employee implements Serializable {
    @NotNull
    @Id
    private String staffId;
    @NotNull
    private String Email;
    @NotNull
    private String Name;

    protected Employee() {
    }

    //====================================================
    //Private Constructor
    public Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.Email = builder.email;
        this.Name = builder.name;
    }

    //====================================================
    //Getters
    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    //====================================================
    // toString
    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    //====================================================
    // Builder Pattern
    public static class Builder {
        private String staffId;
        private String email;
        private String name;

        public Employee.Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Employee.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Employee.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Employee.Builder copy(Employee employee) {
            this.staffId = employee.getStaffId();
            this.email = employee.getEmail();
            this.name = employee.getName();
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        public static class StaffId {
            private String staffId;

            public StaffId(String staffId) {
                this.staffId = staffId;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                StaffId staffId1 = (StaffId) o;
                return staffId.equals(staffId1.staffId);
            }

            @Override
            public int hashCode() {
                return Objects.hash(staffId);
            }
        }
    }
}

