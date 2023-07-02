package com.example.testspringdata;

import javax.persistence.*;

@Entity
@Table(name = "\"Usertyprlink\"")
public class Usertyprlink {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Lob
    @Column(name = "type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}