package com.example.springbootwebadmin.controller;

import com.example.springbootwebadmin.bean.Book;
import com.example.springbootwebadmin.bean.City;
import com.example.springbootwebadmin.bean.User;
import com.example.springbootwebadmin.service.BookService;
import com.example.springbootwebadmin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    BookService bookService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/book")
    public Book getById(@RequestParam("id") Integer id){
        return bookService.getById(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public City insertData(City city){
        cityService.insertData(city);
        return city;
    }


    /**
     * 来登錄頁
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String index(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            //把登錄成功的用戶保存起來
            session.setAttribute("loginUser",user);
            //登錄成功重定向到main.html;重定向防止表單重複提交
            return "redirect:/index.html";
        }else {
            model.addAttribute("msg","賬號密碼錯誤");
            return "login";
        }
    }

    /**
     * 去index頁面
     * @return
     */
    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
        log.info("當前方式是:{}","indexPage");
//        Object user = session.getAttribute("loginUser");
//        if (user != null){
//            return "index";
//        }else{
//            model.addAttribute("msg","Pls login");
//            return "login";
//        }
        return "index";
    }
}
