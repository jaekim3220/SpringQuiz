package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.Realtor;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface RealtorMapper {

	
	// input : realtor 데이터
	// output : int or void
	public void insertRealtor(Realtor realtor);
	
	
	// input : realtor 데이터
	// output : int or void
	public Realtor selectRealtorById(int id);
	
}
