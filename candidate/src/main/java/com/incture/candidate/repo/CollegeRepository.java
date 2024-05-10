package com.incture.candidate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.candidate.entity.CollegeTPO;

public interface CollegeRepository extends JpaRepository<CollegeTPO, Integer> {

     
} 
