package com.example.demo.controller;

import com.example.demo.model.AddBannerRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leslie.Lam
 * @create 2018-08-20 13:30
 **/
@RestController
@RequestMapping("banner")
public class BannerController {

    @PostMapping
    public String addBanner(@RequestBody AddBannerRequest addBannerRequest){
        return "success";
    }

}
