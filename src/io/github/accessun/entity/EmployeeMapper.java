package io.github.accessun.entity;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    
    List<Employee> selectEmployees(String city);
    
    Employee selectEmployee();
    
    List<Employee> selectEmployeeWhen(Employee employee);
    
    List<Employee> selectEmployeeWhere(Employee employee);
    
    List<Employee> selectEmployeeIn(List<Integer> ids);
    
    List<Employee> selectEmployeeBind(String pattern);
    
    Map<String, Object> selectEmployeeHashMap(Integer id);
    
    void insertEmployee(Employee employee);
    
    void insertEmployeeMultiRow(List<Employee> employees);
    
    void deleteOne(Integer id);
    
    void deleteBatch(List<Integer> ids);
    
    void updateEmployeeSet(Employee employee);

}
