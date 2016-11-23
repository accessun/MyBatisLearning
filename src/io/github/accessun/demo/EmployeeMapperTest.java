package io.github.accessun.demo;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import io.github.accessun.entity.EmployeeMapper;
import io.github.accessun.utils.MyBatisUtils;

public class EmployeeMapperTest {
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testSelectDepartmentCount() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectDepartments() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeeById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectDepartmentByDeptId() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeeIntoHashMap() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectAllEmployeeIds() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testDeleteEmployeeById() {
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();
    }

    @Test
    public void testSelectEmployeesByGender() {
        fail("Not yet implemented");        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        
        
        session.close();    }

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
