package com.yanghui.dao;

import com.yanghui.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//连接数据库后，要写数据访问层dao，这里一般是增删改查，我们要些接口
public interface BookMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(@Param("bookID")int id);
    //查询所有书
    List<Books> queryAllBook();
    //从接口开始
    Books queryBooKByName(@Param("bookName") String bookName);
}
