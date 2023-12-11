package pro.sky.sky.pro.homework19.model;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstName, String fullName) {
        this.firstName = firstName;
        this.lastName = fullName;

    }

    public Employee() {
    }

    public String getFirstName() {

        return firstName;
    }

    public String getFullName() {

        return lastName;
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
}

