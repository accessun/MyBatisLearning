package io.github.accessun.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.accessun.entity.Blog;
import io.github.accessun.utils.MyBatisUtils;

public class ComplexCRUDTest {

    private SqlSession sqlSession = null;
    
    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtils.getSqlSession();
    }

    @After
    public void tearDown() throws Exception {
        MyBatisUtils.releaseSession(sqlSession);
        sqlSession = null;
    }

    @Test
    public void testSelectBlog() {
        Blog blog = sqlSession.selectOne("blog_db_op.selectBlog", 2);
        System.out.println(blog);
    }

}
