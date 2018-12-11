package com.example.demo;

import com.example.demo.biz.SystemHookBiz;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private SystemHookBiz hookBiz;

    @Test
    public void contextLoads() {
    }


    @Test
    public void gitclone() throws GitAPIException {
        //hookBiz.gitClone("lijiyang", "");
        hookBiz.gitClone("http://192.168.102.111/test/spring-test.git",new File("d:\\lijiyang"));
    }

    @Test
    public void gitPull(){
        hookBiz.gitPull(new File("d:\\lijiyang"));
    }

    @Test
    public void gitPush(){
        hookBiz.gitPush(new File("d:\\lijiyang"), "http://192.168.102.111/testGroup/spring-test.git");
    }
}
