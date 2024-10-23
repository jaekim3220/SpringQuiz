package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity studentEntity);
}
