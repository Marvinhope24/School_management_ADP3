/*
Tiffany Kiwiets - 219322732
Student.java
15 June 2022
 */

package za.ac.cput.School_Management.Domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Student {

    //constructors
    @NotNull
    @Id private String studentId;
    @NotNull private String Email;
    @Embedded
    Name Name;

    protected Student() {

    }

    //private constructors
    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.Email = builder.email;
        this.Name = builder.name;

    }

    //getters
    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return Email;
    }

    public za.ac.cput.School_Management.Domain.Name getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && Email.equals(student.Email) && Name.equals(student.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, Email, Name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", Email='" + Email + '\'' +
                ", Name=" + Name +
                '}';
    }

    //builder patter
    public static class Builder {
        private String studentId;
        private String email;
        private Name name;

        public Student.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Student.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Student.Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.email = student.Email;
            this.name = student.Name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}
