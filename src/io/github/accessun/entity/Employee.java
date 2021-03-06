package io.github.accessun.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private int age;
    private String email;
    private int salary;
    private Date dateOfBirth;
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(String name, String gender, int age, String email, int salary, Date dateOfBirth,
            Department department) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
    }

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateOfBirth = format.format(dateOfBirth);

        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", email=" + email
                + ", salary=" + salary + ", dateOfBirth=" + formattedDateOfBirth + ", department=" + department + "]";
    }

}
