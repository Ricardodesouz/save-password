package com.turtle.savepassword.entities;

import com.turtle.savepassword.entities.assist.Password;
import jakarta.persistence.Entity;

@Entity
public class PasswordWebSite extends Password {
    private String url;
    private String userName;

    public PasswordWebSite(){};

    public PasswordWebSite(Integer id, String nameDescription, String password, String url,String userName){
        super(id, nameDescription, password);
        this.url = url;
        this.userName = userName;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PasswordWebSite{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
