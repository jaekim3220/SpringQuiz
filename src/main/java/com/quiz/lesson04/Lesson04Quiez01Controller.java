package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RequestMapping("/lesson04/quiz01")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Quiez01Controller {

	
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
	@RequestMapping(path = "/add-seller-view", method = RequestMethod.GET)
	public String addSellerView() {
		return "/lesson04/addSeller"; // HTML 경로
	}
	
	// 입력, 수신한 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-seller")
	public String addSeller() {
		
	}
	
	
}
