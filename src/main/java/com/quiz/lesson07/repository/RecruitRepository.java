package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {

	// 조회 - SELECT
	//JPQL 메소드 생성
	// Entity에 조회
	
	// 1. id 로 조회
	// public RecruitEntity findById(int id);
	
	// 2. Parameter 조건 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// 3. 복합 조건 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4. 복합 조건 조회
	
	// 5. 정렬 제한 조건
	public List<RecruitEntity> findTop3ByOrderBySalaryDesc();
	
	// 6. 범위 조회
	public List<RecruitEntity> findByRegionAndSalaryBetween(String Region, int startSalary, int endSalary);
	
}
