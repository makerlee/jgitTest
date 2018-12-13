package com.example.demo.entity;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-12-13 22:31:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ListCommit {

    private String id;
    private String short_id;
    private String title;
    private String author_name;
    private String author_email;
    private Date authored_date;
    private String committer_name;
    private String committer_email;
    private Date committed_date;
    private Date created_at;
    private String message;
    private List<String> parent_ids;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setShort_id(String short_id) {
        this.short_id = short_id;
    }
    public String getShort_id() {
        return short_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }
    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthored_date(Date authored_date) {
        this.authored_date = authored_date;
    }
    public Date getAuthored_date() {
        return authored_date;
    }

    public void setCommitter_name(String committer_name) {
        this.committer_name = committer_name;
    }
    public String getCommitter_name() {
        return committer_name;
    }

    public void setCommitter_email(String committer_email) {
        this.committer_email = committer_email;
    }
    public String getCommitter_email() {
        return committer_email;
    }

    public void setCommitted_date(Date committed_date) {
        this.committed_date = committed_date;
    }
    public Date getCommitted_date() {
        return committed_date;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public Date getCreated_at() {
        return created_at;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setParent_ids(List<String> parent_ids) {
        this.parent_ids = parent_ids;
    }
    public List<String> getParent_ids() {
        return parent_ids;
    }

}