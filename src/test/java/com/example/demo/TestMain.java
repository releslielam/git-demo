package com.example.demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Leslie.Lam
 * @create 2018-08-21 15:00
 **/
public class TestMain {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIN));
        Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIN));
        long seconds = duration.getSeconds();
        System.out.println(seconds);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 11; i++) {
//            sb.append("蓝月亮");
//        }
//        System.out.println(sb.toString().matches("[\u4e00-\u9fa5]{1,30}"));
    }

}
