package com.example.demo.agent;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("TmsAgent")
public class TmsAgent implements Agent{
    @Override
    public List<String> listUser(String deptId){
        //http调用tms获取用户
        int retry = 5;

        while (retry<5){

        }


        return null;
    }
}
