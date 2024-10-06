package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RestController // 어노테이션 (Spring Bean 등록)
public class Lesson03Quiz04RestController {

	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private RealEstateBo realestateBo;
	
	/*
	1. delete
	parameter로 받은 id의 행을 삭제하세요.
	삭제 성공한 행의 수를 출력 예시처럼 Response String으로 브라우저에서 출력하세요.
	
	요청 Path 예시 : /lesson03/quiz04/1?id=21
	
	출력 예시
	삭제 성공 : 1
	*/
	
	@RequestMapping("/lesson03/quiz04/1")
	public String quiz04(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("id") int id) {
		// Service(BO)영역에서 void로 메서드를 생성할 경우 return 값이 주어지지 않음
		// Service(BO)영역에서 해당 메서드를 변경해야 DB의 성공행 개수를 반환(return) 가능
		realestateBo.deleteRealEstateByID(id);
		return "삭제 성공";
	}
	
}
