// Marvin Hope -219445842

package za.ac.cput.School_Management.Domain.Employee;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
public class Employee {

   @Embedded private String staffId;
   @NotNull private String email;
   @NotNull private String name;
    protected Employee(){}
    private Employee(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public static class Builder implements Serializable {
        private String email,name;
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder copy(Employee employee) {
            this.email = employee.email;
            this.name = employee.name;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(email, builder.email) && Objects.equals(name, builder.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(email, name);
        }
        @Override
        public String toString() {
            return "Builder{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
