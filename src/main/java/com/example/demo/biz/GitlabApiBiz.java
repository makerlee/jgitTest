package com.example.demo.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.ListCommit;
import com.example.demo.entity.ListGroup;
import com.example.demo.entity.Project;
import com.example.demo.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GitlabApiBiz {
    @Value("${git.api.host}")
    private String host;

    @Value("${git.api.token}")
    private String token;

    public void getGroup(Integer topGroup, List<ListGroup> all) throws Exception {
        String url = host + "/groups/" + topGroup + "/subgroups?private_token=" + token;
        String s = HttpClientUtil.doGet(new URI(url));
        List<ListGroup> listGroups = JSON.parseArray(s, ListGroup.class);
        if (listGroups==null || listGroups.size()<1){
            return;
        }
        for (ListGroup listGroup:listGroups){
            all.add(listGroup);
            int id = listGroup.getId();
            getGroup(id, all);
        }
    }

    public List<Project> getAllProject(Integer groupId) throws Exception {
        String url = host + "/groups/" + groupId + "/projects?private_token=" + token;
        String s = HttpClientUtil.doGet(new URI(url));
        List<Project> projects = JSONArray.parseArray(s, Project.class);
        return projects;
    }

    public List<ListCommit> listRepoCommit(int project_id, String branch) throws Exception{
        String url = host + "/projects/" + project_id + "/repository/commits?ref_name="+branch+"&private_token=" + token;
        String s = HttpClientUtil.doGet(new URI(url));
        List<ListCommit> commits = JSONArray.parseArray(s, ListCommit.class);
        return commits;
    }

}
