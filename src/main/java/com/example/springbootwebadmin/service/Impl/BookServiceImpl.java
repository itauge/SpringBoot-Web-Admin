package com.example.springbootwebadmin.service.Impl;

import com.example.springbootwebadmin.bean.Book;
import com.example.springbootwebadmin.mapper.BookMapper;
import com.example.springbootwebadmin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    public Book getById(Integer id){
       return bookMapper.getById(id);
    }

}
