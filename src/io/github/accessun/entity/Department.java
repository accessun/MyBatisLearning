package io.github.accessun.entity;

public class Department {
    private Integer id;
    private String deptName;
    private String location;
    private Employee manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department() {
    }

    public Department(String deptName, String location, Employee manager) {
        super();
        this.deptName = deptName;
        this.location = location;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptName=" + deptName + ", location=" + location + ", manager=" + manager
                + "]";
    }

}
