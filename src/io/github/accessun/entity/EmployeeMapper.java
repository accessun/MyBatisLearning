package io.github.accessun.entity;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    
    int selectDepartmentCount();
    
    List<Department> selectDepartments(int number);
    
    Employee selectEmployeeById(Integer id);

    Department selectDepartmentById(Integer id);
    
    Map<String, Object> selectEmployeeIntoHashMap(Integer id);
    
    List<Integer> selectAllEmployeeIds();
    
    void deleteEmployeeById(Integer id);
    
    
    List<Employee> selectEmployeesByGender(Employee emp);
    
    List<Employee> selectEmployeesByGenderAndName(Employee emp);
    
    List<Employee> selectEmployeesByConditions(Employee emp);
    
    List<Employee> selectEmployeesByIds(List<Integer> ids);
    
    void insertEmployee(Employee employee);
    
    void insertEmployees(List<Employee> employees);
    
    void deleteEmployeesByIds(List<Integer> ids);
    
    void updateEmployeeInfosById(Employee emp);
    
    List<Employee> selectEmployeeByNamePattern(String paramPattern);
    
}
