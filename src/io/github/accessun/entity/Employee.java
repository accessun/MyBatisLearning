package io.github.accessun.entity;

public class Employee {

    private Integer id;
    private String name;
    private String gender;
    private int salary;
    private int age;
    private String city;
    private int deptId;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Employee() {
    }
    
    public Employee(String name, String gender, int salary, int age, String city, int deptId) {
        super();
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
        this.city = city;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", age=" + age
                + ", city=" + city + ", deptId=" + deptId + "]";
    }

}
