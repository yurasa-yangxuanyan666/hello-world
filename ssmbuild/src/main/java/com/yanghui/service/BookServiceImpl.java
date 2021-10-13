package com.yanghui.service;

import com.yanghui.dao.BookMapper;
import com.yanghui.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //service层调用dao层;组合dao层
    //这样要是有其他事务可以aop横切进去
    private BookMapper bookMapper;
    private void setBookMapper(Books books){
        this.bookMapper=bookMapper;//这就是组合dao层//使用set方法可以让它被Spring托管
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBooKByName(bookName);
    }
}
//mybatis写完就是要写spring层写spring-dao.xml