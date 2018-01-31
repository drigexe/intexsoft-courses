package com.intexsoft.courses.vysocki.library.model;

public class LibraryDepartment {
    private String name;
    private String website;
    private String path;
    private String id;

    public LibraryDepartment(String name, String website, String path, String id) {
        this.setId(id);
        this.setName(name);
        this.setPath(path);
        this.setWebsite(website);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
