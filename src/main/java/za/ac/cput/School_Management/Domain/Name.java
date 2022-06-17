package za.ac.cput.School_Management.Domain;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Objects;

@Embeddable
public class Name {
    @NotNull
    private String firstname;
    @NotNull
    private String middlename;
    @NotNull
    private String Lastname;

    protected Name() {
    }

    private Name(Name.Builder builder) {

        this.firstname = builder.firstname;
        this.middlename = builder.middlename;
        this.Lastname = builder.Lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstname.equals(name.firstname) && middlename.equals(name.middlename) && Lastname.equals(name.Lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, middlename, Lastname);
    }
    @Override
    public String toString() {
        return "Name{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", Lastname='" + Lastname + '\'' +
                '}';
    }

    public static class Builder {
        private String firstname ,middlename,Lastname;

        public Name.Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Name.Builder MiddleName(String MiddleName) {
            this.middlename = middlename;
            return this;
        }

        public Name.Builder LastName(String Lastname) {
            this.Lastname = Lastname;
            return this;
        }

        public Name.Builder copy(Name name) {
            this.firstname = name.firstname;
            this.middlename = name.middlename;
            this.Lastname = name.Lastname;
            return this;
        }
        public Name build() {
            return new Name(this);
        }
    }
}
