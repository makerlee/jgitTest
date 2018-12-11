package com.example.demo.entity;

import java.util.List;

/**
 * Auto-generated: 2018-12-11 22:36:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HookRequestBody {

    private String object_kind;
    private String event_name;
    private String before;
    private String after;
    private String ref;
    private String checkout_sha;
    private String message;
    private int user_id;
    private String user_name;
    private String user_username;
    private String user_email;
    private String user_avatar;
    private int project_id;
    private Project project;
    private List<Commits> commits;
    private int total_commits_count;
    private Repository repository;
    public void setObject_kind(String object_kind) {
        this.object_kind = object_kind;
    }
    public String getObject_kind() {
        return object_kind;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
    public String getEvent_name() {
        return event_name;
    }

    public void setBefore(String before) {
        this.before = before;
    }
    public String getBefore() {
        return before;
    }

    public void setAfter(String after) {
        this.after = after;
    }
    public String getAfter() {
        return after;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getRef() {
        return ref;
    }

    public void setCheckout_sha(String checkout_sha) {
        this.checkout_sha = checkout_sha;
    }
    public String getCheckout_sha() {
        return checkout_sha;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }
    public String getUser_username() {
        return user_username;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_email() {
        return user_email;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }
    public String getUser_avatar() {
        return user_avatar;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
    public int getProject_id() {
        return project_id;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public Project getProject() {
        return project;
    }

    public void setCommits(List<Commits> commits) {
        this.commits = commits;
    }
    public List<Commits> getCommits() {
        return commits;
    }

    public void setTotal_commits_count(int total_commits_count) {
        this.total_commits_count = total_commits_count;
    }
    public int getTotal_commits_count() {
        return total_commits_count;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    public Repository getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return "HookRequestBody{" +
                "object_kind='" + object_kind + '\'' +
                ", event_name='" + event_name + '\'' +
                ", before='" + before + '\'' +
                ", after='" + after + '\'' +
                ", ref='" + ref + '\'' +
                ", checkout_sha='" + checkout_sha + '\'' +
                ", message='" + message + '\'' +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_username='" + user_username + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", project_id=" + project_id +
                ", project=" + project +
                ", commits=" + commits +
                ", total_commits_count=" + total_commits_count +
                ", repository=" + repository +
                '}';
    }
}
