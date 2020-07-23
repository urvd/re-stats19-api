package com.backend.restats19api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name="task_generator", sequenceName = "task_user_seq", initialValue = 100, allocationSize=9000)
    private Long idtask;
    private String type;
    private String status;
    private String dateHour;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="iduser", nullable=false)
    private Users user;
}
