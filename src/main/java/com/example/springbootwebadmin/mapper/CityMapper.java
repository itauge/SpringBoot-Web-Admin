package com.example.springbootwebadmin.mapper;

import com.example.springbootwebadmin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//如果在主程序@MapperScan 就不用写mapper
//@Mapper
public interface CityMapper {
//    注解模式
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    public void insert(City city);
}
