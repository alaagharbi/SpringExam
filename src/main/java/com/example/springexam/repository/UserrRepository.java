package com.example.springexam.repository;

import com.example.springexam.entity.Sprint;
import com.example.springexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserrRepository extends JpaRepository<User, Integer> {
    public User findById(int id);

}
