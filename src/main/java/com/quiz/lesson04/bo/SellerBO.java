package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.mapper.SellerMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class SellerBO {
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private SellerMapper sellerMapper;
	
	
	// input : 3개 파라미터
	// output : X
	// MVC Cycle 1-1 문제 : seller 추가
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
}
