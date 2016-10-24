package io.github.accessun.test;

import org.junit.Test;

import io.github.accessun.utils.MyBatisUtils;

public class DBConnectionTest {

    @Test
    public void testGetSession() {
        System.out.println(MyBatisUtils.getSqlSession());
    }
}
