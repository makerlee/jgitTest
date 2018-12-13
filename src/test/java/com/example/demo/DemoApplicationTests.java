package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.biz.GitlabApiBiz;
import com.example.demo.biz.SystemHookBiz;
import com.example.demo.entity.ListCommit;
import com.example.demo.entity.ListGroup;
import com.example.demo.entity.Project;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private SystemHookBiz hookBiz;

    @Autowired
    private GitlabApiBiz gitlabApiBiz;

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

    @Test
    public void test() throws Exception {
        List<ListGroup> all = new ArrayList<>();
        gitlabApiBiz.getGroup(4, all);
        System.out.println(JSONArray.toJSONString(all));

        List<Project> allProject = new ArrayList<>();
        for (ListGroup listGroup:all){
            List<Project> sub = gitlabApiBiz.getAllProject(listGroup.getId());
            if (null!=sub&&sub.size()>0){
                allProject.addAll(sub);
            }
        }
        System.out.println("項目總數："+allProject.size());

        for (Project project:allProject){
            List<ListCommit> listCommits = gitlabApiBiz.listRepoCommit(project.getId(), "releas*");
            System.out.println(project.getPath_with_namespace());
            System.out.println(JSONArray.toJSONString(listCommits));
        }

    }
}
