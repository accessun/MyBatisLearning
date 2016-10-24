package io.github.accessun.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.accessun.entity.Employee;
import io.github.accessun.utils.MyBatisUtils;

public class CRUDTest {

    private SqlSession sqlSession = null;

    @Before
    public void setUp() {
        sqlSession = MyBatisUtils.getSqlSession();
    }

    @After
    public void tearDown() {
        MyBatisUtils.releaseSession(sqlSession);
        sqlSession = null;
    }

    @Test
    public void testSelectOne() {
        Employee worker = sqlSession.selectOne("employee_db_op.selectEmployee");

        System.out.println(worker);
    }

    @Test
    public void testSelectList() {
        Employee parameter = new Employee();
        parameter.setCity("Beijing");

        List<Employee> workers = sqlSession.selectList("employee_db_op.selectEmployees", parameter);

        System.out.println(workers);
    }

    @Test
    public void testSelectEmployeeWhen() {
        Employee parameter = new Employee();
        parameter.setName("Tom");
        parameter.setGender("female");
        System.out.println(sqlSession.selectList("employee_db_op.selectEmployeeWhen", parameter));

        parameter = new Employee();
        parameter.setGender("female");
        System.out.println(sqlSession.selectList("employee_db_op.selectEmployeeWhen", parameter));
    }

    @Test
    public void testSelectEmployeeWhere() {
        Employee parameter = new Employee();
        //parameter.setName("Tom");
        parameter.setGender("male");
        System.out.println(sqlSession.selectList("employee_db_op.selectEmployeeWhere", parameter));
    }

    @Test
    public void testDelete() {
        sqlSession.delete("employee_db_op.deleteOne", 5);
        sqlSession.commit();
    }

    @Test
    public void testBatchDelete() {
        sqlSession.delete("employee_db_op.deleteBatch", Arrays.asList(4, 6));
        sqlSession.commit();
    }
    
    @Test
    public void testUpdateSet() {
        Employee parameter = new Employee();
        parameter.setId(1);
        parameter.setAge(25);
        sqlSession.update("employee_db_op.updateEmployeeSet", parameter);
        sqlSession.commit();
    }
    
    @Test
    public void testSelectIn() {
        System.out.println(sqlSession.selectList("employee_db_op.selectEmployeeIn", Arrays.asList(1, 3, 5)));
    }
    
    @Test
    public void testSelectBind() {
        System.out.println(sqlSession.selectList("employee_db_op.selectEmployeeBind", "om"));
    }
    
    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setName("Steve");
        employee.setAge(32);
        employee.setCity("Los Angeles");
        employee.setDeptId(5);
        employee.setGender("male");
        employee.setSalary(8700);
        sqlSession.insert("employee_db_op.insertEmployee", employee);
        sqlSession.commit();
    }
    
    @Test
    public void testInsertMultiRow() {
        Employee employee1 = new Employee("Cook", "male", 8900, 21, "Shanghai", 1);
        Employee employee2 = new Employee("Agnes", "female", 7000, 24, "Shanghai", 4);
        Employee employee3 = new Employee("Anna", "female", 7800, 25, "Beijing", 3);
        
        List<Employee> employeesToInsert = new ArrayList<>();
        employeesToInsert.add(employee1);
        employeesToInsert.add(employee2);
        employeesToInsert.add(employee3);
        
        sqlSession.insert("employee_db_op.insertEmployeeMultiRow", employeesToInsert);
        sqlSession.commit();
    }

    
    @Test
    public void testSelectHashMap() {
        Map<String, Object> employee = sqlSession.selectOne("employee_db_op.selectEmployeeHashMap", 1);
        System.out.println(employee);
    }
}
