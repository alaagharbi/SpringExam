package com.example.springexam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    private String title;
    private String description;
    @ManyToMany(mappedBy = "projects",fetch = FetchType.EAGER)
    private List<User> users;
    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints;
}
