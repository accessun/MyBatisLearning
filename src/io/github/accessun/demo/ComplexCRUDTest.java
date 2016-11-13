package io.github.accessun.demo;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.accessun.entity.Blog;
import io.github.accessun.entity.BlogMapper;
import io.github.accessun.utils.MyBatisUtils;

public class ComplexCRUDTest {

    private SqlSession sqlSession = null;
    private BlogMapper blogMapper = null;
    
    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtils.getSession();
        blogMapper = sqlSession.getMapper(BlogMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void testSelectBlog() {
        Blog blog = blogMapper.selectBlog(2);
        System.out.println(blog);
    }

}
