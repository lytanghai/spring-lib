package com.socket_io.websocket.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();

    public User() {}
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
