package com.im.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Agent implements User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int password;
    private String role;
    private boolean enabled;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "AGENT_POLICY_TABLE",
//    joinColumns = {
//            @JoinColumn(name = "agent_id", referencedColumnName = "id")
//    },
//    inverseJoinColumns = {
//            @JoinColumn(name = "policy_id", referencedColumnName = "policyId")
//    })
//    private Set<Policy> policies;



    public Agent(int id, String name, int password, String role, boolean enabled) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public Agent(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
