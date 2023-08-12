package lab.model;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/***
 * Class representing a student with simple fields: id, firstName, lastName, birthday.
 * The corresponding database table is:
 *    CREATE TABLE students (
 *       id INT NOT NULL PRIMARY KEY,
 *       firstName CHAR(40) NOT NULL,
 *       lastName CHAR (40) NOT NULL,
 *       birthday DATE
 *    )
 */

// The Student class could be defined in a way more concise way with the use of a record class.
// It is a fairly new and very useful new Java feature:
// https://docs.oracle.com/en/java/javase/17/language/records.html
public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Optional<Date> birthday;
    
    public Student(final int id, final String firstName, final String lastName, final Optional<Date> birthday) {
        this.id = id;
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.birthday = Objects.requireNonNull(birthday);
    }
    
    public Student(final int id, final String firstName, final String lastName) {
        this(id, firstName, lastName, Optional.empty());
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public Optional<Date> getBirthday() {
        return this.birthday;
    }
    
    @Override
    public String toString() {
        return new StringBuilder()
            .append("(").append(id).append(") ")
            .append(firstName).append(" ").append(lastName)
            .append(" - ").append(birthday).toString();
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof Student)
                && ((Student) other).getId() == this.getId()
                && ((Student) other).getFirstName().equals(this.getFirstName())
                && ((Student) other).getLastName().equals(this.getLastName())
                && ((Student) other).getBirthday().equals(this.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, firstName, id, lastName);
    }
}
