package io.github.accessun.entity;

public interface BlogMapper {
    
    Author selectAuthor(Integer id);
    
    Blog selectBlog(Integer id);
    
}
