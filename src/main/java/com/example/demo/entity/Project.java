package com.example.demo.entity;

/**
 * Auto-generated: 2018-12-11 22:36:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Project {

    private int id;
    private String name;
    private String description;
    private String web_url;
    private String avatar_url;
    private String git_ssh_url;
    private String git_http_url;
    private String namespace;
    private int visibility_level;
    private String path_with_namespace;
    private String default_branch;
    private String ci_config_path;
    private String homepage;
    private String url;
    private String ssh_url;
    private String http_url;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
    public String getWeb_url() {
        return web_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url() {
        return avatar_url;
    }

    public void setGit_ssh_url(String git_ssh_url) {
        this.git_ssh_url = git_ssh_url;
    }
    public String getGit_ssh_url() {
        return git_ssh_url;
    }

    public void setGit_http_url(String git_http_url) {
        this.git_http_url = git_http_url;
    }
    public String getGit_http_url() {
        return git_http_url;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    public String getNamespace() {
        return namespace;
    }

    public void setVisibility_level(int visibility_level) {
        this.visibility_level = visibility_level;
    }
    public int getVisibility_level() {
        return visibility_level;
    }

    public void setPath_with_namespace(String path_with_namespace) {
        this.path_with_namespace = path_with_namespace;
    }
    public String getPath_with_namespace() {
        return path_with_namespace;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }
    public String getDefault_branch() {
        return default_branch;
    }

    public void setCi_config_path(String ci_config_path) {
        this.ci_config_path = ci_config_path;
    }
    public String getCi_config_path() {
        return ci_config_path;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public String getHomepage() {
        return homepage;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }
    public String getSsh_url() {
        return ssh_url;
    }

    public void setHttp_url(String http_url) {
        this.http_url = http_url;
    }
    public String getHttp_url() {
        return http_url;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", web_url='" + web_url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", git_ssh_url='" + git_ssh_url + '\'' +
                ", git_http_url='" + git_http_url + '\'' +
                ", namespace='" + namespace + '\'' +
                ", visibility_level=" + visibility_level +
                ", path_with_namespace='" + path_with_namespace + '\'' +
                ", default_branch='" + default_branch + '\'' +
                ", ci_config_path='" + ci_config_path + '\'' +
                ", homepage='" + homepage + '\'' +
                ", url='" + url + '\'' +
                ", ssh_url='" + ssh_url + '\'' +
                ", http_url='" + http_url + '\'' +
                '}';
    }
}