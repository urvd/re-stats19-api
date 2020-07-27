package com.backend.restats19api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
public class Users {
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq", initialValue = 1000, allocationSize=1000)
    private Long iduser;
    private String username;
    private String password;
    private boolean connectstatus;
    private String sessionid;
    @OneToMany(mappedBy="user", cascade=CascadeType.REFRESH, orphanRemoval = true)
    Set<Tasks> tasks;
}
