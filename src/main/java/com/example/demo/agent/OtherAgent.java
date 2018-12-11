package com.example.demo.agent;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("OtherAgent")
public class OtherAgent implements Agent {
    @Override
    public List<String> listUser(String deptId) {
        //
        return null;
    }
}
