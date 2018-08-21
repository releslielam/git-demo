package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Leslie.Lam
 * @create 2018-08-20 13:30
 **/
@Controller
@RequestMapping("views")
public class PageController {

    @GetMapping("banner-add")
    public String toBannerAdd(){
        return "banner-add";
    }

}
