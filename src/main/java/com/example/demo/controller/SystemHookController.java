package com.example.demo.controller;

import com.example.demo.biz.SystemHookBiz;
import com.example.demo.entity.HookRequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/hook")
public class SystemHookController {

    @Autowired
    private SystemHookBiz hookBiz;

    @PostMapping(value = "/trigger")
    public String hookTrigger(@RequestBody HookRequestBody hookInfo) throws JsonProcessingException, GitAPIException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(hookInfo);
        hookBiz.handleEvent(hookInfo);
        return s;
    }


}
