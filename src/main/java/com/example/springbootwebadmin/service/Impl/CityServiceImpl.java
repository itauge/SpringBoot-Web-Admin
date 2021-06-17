package com.example.springbootwebadmin.service.Impl;

import com.example.springbootwebadmin.bean.City;
import com.example.springbootwebadmin.mapper.CityMapper;
import com.example.springbootwebadmin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void insertData(City city){
        cityMapper.insert(city);
    }
}
