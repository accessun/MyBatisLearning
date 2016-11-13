package io.github.accessun.demo;

import org.junit.Assert;
import org.junit.Test;

import io.github.accessun.utils.MyBatisUtils;

public class DBConnectionTest {

    @Test
    public void testGetSession() {
        String expectedSqlSessionQualifiedClassName = "org.apache.ibatis.session.defaults.DefaultSqlSession";
        Assert.assertEquals(expectedSqlSessionQualifiedClassName, MyBatisUtils.getSession().getClass().getName());
    }
    
}
