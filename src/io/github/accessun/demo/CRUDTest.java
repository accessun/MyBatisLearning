package io.github.accessun.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.accessun.entity.Department;
import io.github.accessun.entity.Employee;
import io.github.accessun.entity.EmployeeMapper;
import io.github.accessun.utils.MyBatisUtils;

public class CRUDTest {

    private SqlSession sqlSession = null;
    private EmployeeMapper empMapper = null;
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    @Before
    public void setUp() {
        sqlSession = MyBatisUtils.getSession();
        empMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @After
    public void tearDown() {
        sqlSession.close();
    }

    @Test
    public void testSelectOne() {
        Employee worker = empMapper.selectEmployee();
        System.out.println(worker);
    }

    @Test
    public void testSelectList() {
        List<Employee> workers = empMapper.selectEmployees("Beijing");
        System.out.println(workers);
    }

    @Test
    public void testSelectEmployeeWhen() {
        Employee parameter = new Employee();
        parameter.setName("Tom");
        parameter.setGender("female");
        System.out.println(empMapper.selectEmployeeWhen(parameter));

        parameter = new Employee();
        parameter.setGender("female");
        System.out.println(empMapper.selectEmployeeWhen(parameter));
    }

    @Test
    public void testSelectEmployeeWhere() {
        Employee parameter = new Employee();
        //parameter.setName("Tom");
        parameter.setGender("male");
        System.out.println(empMapper.selectEmployeeWhere(parameter));
    }

    @Test
    public void testDelete() {
        empMapper.deleteOne(5);
        sqlSession.commit();
    }

    @Test
    public void testBatchDelete() {
        empMapper.deleteBatch(Arrays.asList(6, 8));
        sqlSession.commit();
    }
    
    @Test
    public void testUpdateSet() {
        Employee parameter = new Employee();
        parameter.setId(1);
        parameter.setAge(25);
        empMapper.updateEmployeeSet(parameter);
        sqlSession.commit();
    }
    
    @Test
    public void testSelectIn() {
        System.out.println(empMapper.selectEmployeeIn(Arrays.asList(1, 3, 7)));
    }
    
    @Test
    public void testSelectBind() {
        System.out.println(empMapper.selectEmployeeBind("am"));
    }
    
    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setName("Steve");
        employee.setAge(32);
        employee.setGender("male");
        employee.setSalary(8700);
        empMapper.insertEmployee(employee);
        sqlSession.commit();
    }
    
    @Test
    public void testInsertMultiRow() throws ParseException {
        
        List<Department> departments = empMapper.selectDepartments(3);
        
        Employee employee1 = new Employee(15101, "Tom Cook", "male", 65, "tom-cook_5bh11@example.com", 30000,
                formatter.parse("1985-05-05"), departments.get(0));
        Employee employee2 = new Employee(15101, "Agnes Anderson", "female", 31, "agnes-anderson_98u12@example.com", 15000,
                formatter.parse("1985-05-05"), departments.get(1));
        Employee employee3 = new Employee(15101, "Anna White", "female", 28, "anna-white_09udf@example.com", 12000,
                formatter.parse("1985-05-05"), departments.get(3));

        List<Employee> employeesToInsert = new ArrayList<>();
        employeesToInsert.add(employee1);
        employeesToInsert.add(employee2);
        employeesToInsert.add(employee3);

        empMapper.insertEmployeeMultiRow(employeesToInsert);
        sqlSession.commit();
    }

    
    @Test
    public void testSelectHashMap() {
        Map<String, Object> employee = empMapper.selectEmployeeHashMap(1);
        System.out.println(employee);
    }
}
