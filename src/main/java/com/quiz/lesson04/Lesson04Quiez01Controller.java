package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Quiez01Controller {

	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private SellerBO sellerBo;
	
	/*
	1. seller 추가
	입력 form을 이용해서 새로운 seller를 DB에 추가하세요.
	입력 form Path : /lesson04/quiz01/add-seller-view
	입력 form html명: addSeller.html
	
	submit 후 아래 페이지에서 '입력 성공' 문구를 출력하세요.
	입력 action Path : /lesson04/quiz01/add-seller
	성공 페이지 결과 html명: afterAddSeller.html
	
	출력 예시 :  입력 성공!
	*/
	
	// 입력 화면 : 판매자 추가
	// http:localhost:80/lesson04/quiz01/add-seller-view
	@RequestMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 입력, 수신한 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-seller")
	public String addSeller(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천) - null이 아닌 column
			@RequestParam("nickname") String nickname,
			@RequestParam("temperature") String temperature,
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl
			) {
		
		// 결과 화면 이동
		return "lesson04/afterAddSeller";
	}
	
}
