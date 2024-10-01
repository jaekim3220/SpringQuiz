package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;
import com.quiz.lesson03.domain.RealEstate;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RestController
@RequestMapping("/lesson03/quiz02")
public class Lesson03Quiz02RestController {

	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private RealEstateBo realestateBo;
	
	
	/*
	1. 객체로 insert 하기
	아래 내용을 객체를 활용해서 insert 하세요.
	입력 성공한 행의 수를 출력 예시처럼 Response String으로 브라우저에서 출력하세요.
	요청 Path: /lesson03/quiz02/1
	
	입력 데이터
	realtorId : 3
	address : 푸르지용 리버 303동 1104호
	area : 89
	type : 매매
	price : 100000
	
	출력 예시
	입력 성공 : 1
	*/
	
	@RequestMapping("/1")
	public String quiz02_1() {
		// INSERT 객체 생성
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		// 생성 객체 INSERT, 성공한 행의 갯수 return
		int rowCount = realestateBo.addRealEstate(realEstate);
		return "입력 성공 : " + rowCount;
	}
	
	
	/*
	2. field 로 insert 하기
	아래 내용을 객체 없이 insert 하세요.
	단, realtorId 는 parameter를 통해서 전달받아서 저장하세요.
	입력 성공한 행의 수를 출력 예시처럼 Response String으로 브라우저에서 출력하세요.
	
	요청 Path 예시 : /lesson03/quiz02/2?realtor_id=5
	
	입력 데이터
	address : 썅떼빌리버 오피스텔 814호
	area : 45
	type : 월세
	price : 100000
	rentPrice : 120
	
	출력 예시
	입력 성공 : 1
	*/
	
	@RequestMapping("/2")
	public String quiz02_2(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("realtor_id") int realtorId
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			// @RequestParam(value = "realtor_id", defaultValue = "1") int realtorId // 기본값 : 1
			) {
		int rowCount = realestateBo.addRealEstateAsField(
				realtorId, "썅떼빌리버 오피스텔 814호", 
				45, "월세", 
				100000, 120);
		return "입력 성공 : " + rowCount;
	}
	
}
