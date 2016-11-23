package io.github.accessun.demo;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import io.github.accessun.entity.Department;
import io.github.accessun.entity.Employee;
import io.github.accessun.entity.EmployeeMapper;
import io.github.accessun.utils.MyBatisUtils;

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
    public void testSelectDepartmentByDeptId() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Department department = mapper.selectDepartmentByDeptId(1);
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
        
        session.commit();
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
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByConditions() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testInsertEmployee() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testInsertEmployees() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testDeleteEmployeesByIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testUpdateEmployeeInfosById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeeByNamePattern() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

}
