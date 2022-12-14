package com.example.springexam.repository;

import com.example.springexam.entity.Sprint;
import com.example.springexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
