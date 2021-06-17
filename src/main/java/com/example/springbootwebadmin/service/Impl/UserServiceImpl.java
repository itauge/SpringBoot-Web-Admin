package com.example.springbootwebadmin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootwebadmin.bean.User;
import com.example.springbootwebadmin.mapper.UserMapper;
import com.example.springbootwebadmin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
