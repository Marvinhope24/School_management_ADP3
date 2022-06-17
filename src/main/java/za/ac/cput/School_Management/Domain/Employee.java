// Marvin Hope -219445842
// Employee.java
// 09 June 2022

package za.ac.cput.School_Management.Domain;

import com.sun.istack.NotNull;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import java.util.Objects;

@Entity
public class Employee {
    @NotNull
    @Id
    private String staffId;
    @NotNull @Email
    private String Email;
    @Embedded
    private Name name;

    protected Employee() {
    }
    private Employee(Builder builder) {
        this.staffId = builder.staffId;
        this.Email = builder.Email;
        this.name = builder.name;
    }

    public String getStaffId() {
        return staffId;
    }
    public String getEmail() {
        return Email;
    }
    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId) && Email.equals(employee.Email) && name.equals(employee.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(staffId, Email, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", Email='" + Email + '\'' +
                ", name=" + name +
                '}';
    }
    public static class Builder {
        private String staffId, Email;
        private Name name;

        public Employee.Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Employee.Builder Email(String Email) {
            this.Email = Email;
            return this;
        }

        public Employee.Builder Name(Name name) {
            this.name = name;
            return this;
        }

        public Builder copy(Employee employee) {
            this.staffId = employee.staffId;
            this.Email = employee.Email;
            this.name = employee.name;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }
}
