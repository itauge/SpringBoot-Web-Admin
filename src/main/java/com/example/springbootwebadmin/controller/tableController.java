package com.example.springbootwebadmin.controller;

import com.example.springbootwebadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表格内容的遍歷
        List<User> users = Arrays.asList(new User("hey", "hey"),
                new User("test", "test"),
                new User("test1", "test1"));

        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}