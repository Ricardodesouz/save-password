package com.turtle.savepassword.entities.assist;

import java.util.Objects;

import com.turtle.savepassword.entities.Folder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nameDescription;
    private String password;
    @ManyToOne
    @JoinColumn(name= "ID_FOLDER")
    private Folder folder;

    public Password(){};

    public Password(Integer id, String nameDescription, String password, Folder folder) {
        this.id = id;
        this.nameDescription = nameDescription;
        this.password = password;
        this.folder = folder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Password password)) return false;
        return Objects.equals(getId(), password.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
