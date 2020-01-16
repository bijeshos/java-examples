package io.github.bijeshos.javaexamples.streams.model;

import java.util.Objects;

public class Employee {
    private int employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private int salary;
    private int departmentId;

    public Employee(int employeeId, String firstName, String middleName, String lastName, int age, int salary,
                    int departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && getAge() == employee.getAge() &&
               getSalary() == employee.getSalary() && getDepartmentId() == employee.getDepartmentId() && Objects.equals(
                getFirstName(), employee.getFirstName()) && Objects.equals(getMiddleName(), employee.getMiddleName()) &&
               Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFirstName(), getMiddleName(), getLastName(), getAge(), getSalary(),
                            getDepartmentId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("employeeId=")
          .append(employeeId);
        sb.append(", firstName='")
          .append(firstName)
          .append('\'');
        sb.append(", middleName='")
          .append(middleName)
          .append('\'');
        sb.append(", lastName='")
          .append(lastName)
          .append('\'');
        sb.append(", age=")
          .append(age);
        sb.append(", salary=")
          .append(salary);
        sb.append(", departmentId=")
          .append(departmentId);
        sb.append('}');
        return sb.toString();
    }
}
