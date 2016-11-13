package io.github.accessun.entity;

public class Department {
    private Integer id;
    private Integer deptId;
    private String deptName;
    private String location;
    private Employee manager;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Department(Integer deptId, String deptName, String location, Employee manager) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.location = location;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", location=" + location
                + ", manager=" + manager + "]";
    }

}
