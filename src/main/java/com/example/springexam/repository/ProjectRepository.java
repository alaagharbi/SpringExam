package com.example.springexam.repository;

import com.example.springexam.entity.Project;
import com.example.springexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public Project findById(int id);

}
