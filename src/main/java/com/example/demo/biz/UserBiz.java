package com.example.demo.biz;

import com.example.demo.agent.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBiz {
    @Autowired
    @Qualifier(value = "OtherAgent")
    private Agent agent;


    public List<String> listUser(){
        return agent.listUser("1");
    }


}
