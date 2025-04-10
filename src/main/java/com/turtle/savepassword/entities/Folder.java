package com.turtle.savepassword.entities;


import com.turtle.savepassword.entities.assist.Password;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Description;
    private Integer userId;

    @OneToMany(mappedBy = "folder")
    private List<Password> passwordList = new ArrayList<>();

    public Folder(){};

    public Folder(Integer id, String description, Integer userId) {
        this.id = id;
        Description = description;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Password> getPasswordList() {
        return passwordList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Folder folder)) return false;
        return Objects.equals(getId(), folder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
