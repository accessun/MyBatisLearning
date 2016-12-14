package io.github.accessun.demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import io.github.accessun.entity.Department;
import io.github.accessun.entity.EmployeeMapper;
import io.github.accessun.utils.MyBatisUtils;

public class CacheDemo {
    
    /*
     *  turn on the log output in `log4j.properties` to see the effects here.
     */

    @Test
    public void testFirstLevelCache() {
        SqlSession session = MyBatisUtils.getSession();
        List<Department> departments = session.getMapper(EmployeeMapper.class).selectDepartments(1);
        List<Department> departments2 = session.getMapper(EmployeeMapper.class).selectDepartments(1);
        System.out.println(departments == departments2);
        session.close();
    }
    
    @Test
    public void testSecondLevelCache() {
        SqlSession session = MyBatisUtils.getSession();
        SqlSession session2 = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
        
        List<Department> departments = mapper.selectDepartments(1);
        List<Department> departments2 = mapper2.selectDepartments(1);
        
        System.out.println(departments == departments2);
        
        session.close();
        session2.close();
    }
    
}
