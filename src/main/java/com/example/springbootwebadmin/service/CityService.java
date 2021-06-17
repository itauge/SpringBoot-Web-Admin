package com.example.springbootwebadmin.service;

import com.example.springbootwebadmin.bean.City;

public interface CityService {

    public City getById(Long id);

    public void insertData(City city);
}
