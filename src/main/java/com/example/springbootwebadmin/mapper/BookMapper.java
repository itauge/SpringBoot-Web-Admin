package com.example.springbootwebadmin.mapper;

import com.example.springbootwebadmin.bean.Book;
import org.apache.ibatis.annotations.Mapper;

//如果在主程序@MapperScan 就不用写mapper
//@Mapper
public interface BookMapper {
    public Book getById(Integer id);
}
