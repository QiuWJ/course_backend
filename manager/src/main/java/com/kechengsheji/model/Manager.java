package com.kechengsheji.model;

import java.util.Date;

public class Manager {

    private Integer id;

    private String username;

    private String password;

    private Date resetpasswordDate;

    public Date getResetpasswordDate() {
        return resetpasswordDate;
    }

    public void setResetpasswordDate(Date resetpasswordDate) {
        this.resetpasswordDate = resetpasswordDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}