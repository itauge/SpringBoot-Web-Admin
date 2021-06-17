package com.example.springbootwebadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootwebadmin.bean.User;
import com.example.springbootwebadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class tableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    /**
     * 从数据库查出user表中的用户
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pg",defaultValue = "1")Integer pg, Model model){
//        //表格内容的遍歷
//        List<User> users = Arrays.asList(new User("hey", "hey"),
//                new User("test", "test"),
//                new User("test1", "test1"));
//
//        model.addAttribute("users",users);
        List<User> list = userService.list();
        //分頁查詢數據
        Page<User> userPage = new Page<>(pg, 2);

        //分頁查詢結果
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getSize();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);


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
