package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5. 정렬 제한 조건
	public List<RecruitEntity> findTop3ByOrderBySalaryDesc();
	
	// 6. 범위 조회
	public List<RecruitEntity> findByRegionAndSalaryBetween(String Region, int startSalary, int endSalary);
	
	// 7. 범위 조회
	// Entity 조회
//		@Query(value = "select s from StudentEntity as s where s.dreamJob = :dreamJob") // value에는 JPQL문이 들어감
//		public List<StudentEntity> findBydreamJob(@Param("dreamJob") String dreamJob);
		
	
	// SQL 쿼리문 - Native Query (DB의 종류에 맞게 해당 SQL 문으로 변환)
	// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회
	@Query(value = "select * from `recruit` "
			+ "where deadline > :deadline "
			+ "and salary >= :salary "
			+ "and type = :type "
			+ "order by salary desc" , nativeQuery = true)
	public List<RecruitEntity> findByCondition(
			@Param("deadline") String deadline, 
			@Param("salary") int salary, 
			@Param("type") String type);
}
