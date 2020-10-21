package com.wbzluntan.usermanager.entity;

public class Tminfo {
    private String username;

    private String logintm;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLogintm() {
        return logintm;
    }

    public void setLogintm(String logintm) {
        this.logintm = logintm == null ? null : logintm.trim();
    }
}