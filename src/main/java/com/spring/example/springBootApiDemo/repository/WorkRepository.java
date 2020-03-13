package com.spring.example.springBootApiDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.example.springBootApiDemo.entity.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{
}
