package com.example.demo.entity;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-12-11 22:38:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Commits {

    private String id;
    private String message;
    private Date timestamp;
    private String url;
    private Author author;
    private List<String> added;
    private List<String> modified;
    private List<String> removed;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAdded(List<String> added) {
        this.added = added;
    }
    public List<String> getAdded() {
        return added;
    }

    public void setModified(List<String> modified) {
        this.modified = modified;
    }
    public List<String> getModified() {
        return modified;
    }

    public void setRemoved(List<String> removed) {
        this.removed = removed;
    }
    public List<String> getRemoved() {
        return removed;
    }

}