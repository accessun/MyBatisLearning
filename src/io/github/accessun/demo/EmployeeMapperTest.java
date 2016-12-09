package io.github.accessun.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import io.github.accessun.entity.Department;
import io.github.accessun.entity.Employee;
import io.github.accessun.entity.EmployeeMapper;
import io.github.accessun.utils.MyBatisUtils;
import io.github.accessun.utils.MyDateTimeUtils;
import io.github.accessun.utils.MyRandomUtils;

public class EmployeeMapperTest {
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testSelectDepartmentCount() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        int count = mapper.selectDepartmentCount();
        System.out.println("selectDepartmentCount => " + count);
        
        session.close();
    }

    @Test
    public void testSelectDepartments() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        List<Department> depts =  mapper.selectDepartments(3);
        System.out.println("selectDepartments =>");
        depts.stream().forEach(System.out::println);
        
        session.close();
    }

    @Test
    public void testSelectEmployeeById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Employee employee = mapper.selectEmployeeById(1);
        System.out.println("selectEmployeeById =>\n" + employee);
        
        session.close();
    }

    @Test
    public void testSelectDepartmentById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Department department = mapper.selectDepartmentById(1);
        System.out.println("selectDepartmentByDeptId =>\n" + department);
        
        session.close();
    }

    @Test
    public void testSelectEmployeeIntoHashMap() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Map<String, Object> empMap = mapper.selectEmployeeIntoHashMap(1);
        System.out.println("selectEmployeeIntoHashMap =>\n" + empMap);
        
        session.close();
    }

    @Test
    public void testSelectAllEmployeeIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        List<Integer> ids = mapper.selectAllEmployeeIds();
        System.out.println("selectAllEmployeeIds => " + ids);
        
        session.close();
    }

    @Test
    public void testDeleteEmployeeById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        mapper.deleteEmployeeById(2);
        
        // session.commit();
        session.close();
    }

    @Test
    public void testSelectEmployeesByGender() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Employee emp = new Employee();
        
        // case 1: gender is null
        List<Employee> employees = mapper.selectEmployeesByGender(emp);
        System.out.println("selectEmployeesByGender (gender not set) =>");
        employees.stream().forEach(System.out::println);
        
        // case 2: gender is set
        emp.setGender("female");
        System.out.println("selectEmployeesByGender (gender is set) =>");
        employees = mapper.selectEmployeesByGender(emp);
        employees.stream().forEach(System.out::println);
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByGenderAndName() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Employee emp = new Employee();
        
        // case 1: gender is not, name is null (default: limit 10 records)
        List<Employee> employees = mapper.selectEmployeesByGenderAndName(emp);
        System.out.println("selectEmployeesByGenderAndName (none is set) =>");
        employees.stream().forEach(System.out::println);
        
        // case 2: name is set, but padded with spaces
        emp.setName(" Carol Morris  ");
        employees = mapper.selectEmployeesByGenderAndName(emp);
        System.out.println("selectEmployeesByGenderAndName (name is set) =>");
        employees.stream().forEach(System.out::println);
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByConditions() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Employee emp = new Employee();
        emp.setGender("female");
        emp.setAge(25); // less than 25
        List<Employee> employees = mapper.selectEmployeesByConditions(emp);
        
        System.out.println("selectEmployeesByConditions =>");
        employees.stream().forEach(System.out::println);
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        List<Employee> employees = mapper.selectEmployeesByIds(Arrays.asList(1, 2, 3));
        System.out.println("selectEmployeesByIds =>");
        employees.stream().forEach(System.out::println);
        
        session.close();
    }

    @Test
    public void testInsertEmployee() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Date dateOfBirth = MyRandomUtils.randomDate();
        int age = MyDateTimeUtils.yearsFrom(dateOfBirth);
        Department department = mapper.selectDepartmentById(1);

        Employee employee = new Employee("Joe Martin", "male", age, "jmartin@example.com", 25000, dateOfBirth, department);
        mapper.insertEmployee(employee);
        
        // session.commit();
        session.close();
    }

    @Test
    public void testInsertEmployees() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        List<Employee> employees = new ArrayList<>();
        
        Date dateOfBirth = MyRandomUtils.randomDate();
        int age = MyDateTimeUtils.yearsFrom(dateOfBirth);
        Department department = mapper.selectDepartmentById(1);
        Employee employee = new Employee("Joe Martin", "male", age, "jmartin@example.com", 25000, dateOfBirth, department);
        employees.add(employee);
        
        dateOfBirth = MyRandomUtils.randomDate();
        age = MyDateTimeUtils.yearsFrom(dateOfBirth);
        department = mapper.selectDepartmentById(2);
        employee = new Employee("Amy Griffin", "female", age, "agriffin@example.com", 22000, dateOfBirth, department);
        employees.add(employee);
        
        mapper.insertEmployees(employees);
        
        // session.commit();
        session.close();
    }

    @Test
    public void testDeleteEmployeesByIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        mapper.deleteEmployeesByIds(Arrays.asList(1, 2, 3));
        
        // session.commit();
        session.close();
    }

    @Test
    public void testUpdateEmployeeInfosById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Employee emp = new Employee();
        
        // case 1: update age only
        emp.setId(1);
        emp.setAge(1); // increment by 1
        mapper.updateEmployeeInfosById(emp);
        
        // case 2: update age and name
        emp.setId(2);
        emp.setName("Woody Allen");
        emp.setAge(1); // increment by 1
        mapper.updateEmployeeInfosById(emp);
        
        // session.commit();
        session.close();
    }

    @Test
    public void testSelectEmployeeByNamePattern() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        List<Employee> employees = mapper.selectEmployeeByNamePattern("llen");
        System.out.println("selectEmployeeByNamePattern =>");
        employees.stream().forEach(System.out::println);
        
        session.close();
    }

}
