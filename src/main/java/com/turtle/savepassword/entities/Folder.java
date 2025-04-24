package com.turtle.savepassword.entities;


import com.turtle.savepassword.entities.assist.Password;
import com.turtle.savepassword.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @OneToMany(mappedBy = "folder")
    private List<Password> passwordList = new ArrayList<>();

    public Folder(){};

    public Folder(Integer id, String description, User user) {
        this.id = id;
        Description = description;
        this.user= user;
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

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
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
