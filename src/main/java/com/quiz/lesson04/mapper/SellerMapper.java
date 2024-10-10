package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface SellerMapper {

	
	// input : 3개 파라미터
	// output : X
	// MVC Cycle 1-1 문제 : seller 추가
	public void insertSeller(
			// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("nickname") String nickname,
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") double temperature);
	
}
