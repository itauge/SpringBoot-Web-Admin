package com.example.springbootwebadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上傳測試
 */
@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自動封裝上傳過來的文件
     * @param email
     * @param password
     * @param headerImage
     * @param manyImage
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestPart("headerImage") MultipartFile headerImage,
                         @RequestPart("manyImage") MultipartFile[] manyImage) throws IOException {
        log.info("上傳的信息：email={},username={},headerImage={},manyImage={}",
                email,password,headerImage,manyImage.length);
        if(!headerImage.isEmpty()){
            //保存到服務器，OSS服務器
            String originalFilename = headerImage.getOriginalFilename();
            headerImage.transferTo(new File("D:\\test\\"+originalFilename));
        }

        if (manyImage.length > 0){
            for (MultipartFile photo : manyImage) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\test\\"+originalFilename));
                }

            }
        }
        return "index";
    }
}
