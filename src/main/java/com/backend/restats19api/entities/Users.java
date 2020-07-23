package com.backend.restats19api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq", initialValue = 1000, allocationSize=1000)
    private Long iduser;
    private String Username;
    private String Password;
    private boolean connectstatus;
    private String sessionid;
    @OneToMany(mappedBy="user", cascade=CascadeType.REFRESH, orphanRemoval = true)
    Set<Tasks> tasks;
}
