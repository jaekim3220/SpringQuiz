package com.quiz.lesson03;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBo;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

/*
<Response 방법 - 서버 기준>
@Controller + return String => ViewResolver => HTML 파일 렌더링(Model) => HTML
@Controller + @ResponseBody return String => HTTPMessageConverter => HTML
@Controller + @ResponseBody return 객체(map, list) => HTTPMessageConverter => jackson => JSON
@RestController return map => JSON
*/
@RestController
@RequestMapping("/lesson03/quiz03")
public class Lesson03Quiz03RestController {

	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private RealEstateBo realestateBo;
	
	/*
	1. update
	id가 8인 행의 type 을 전세로 바꾸고 price를 70000으로 변경하세요. (데이터에 대한 쿼리 파라미터 추가할 것)
	수정 성공한 행의 수를 출력 예시처럼 Response String으로 브라우저에서 출력하세요.
	
	요청 Path : /lesson03/quiz03/1?id=8&type=전세&price=70000
	
	출력 예시
	수정 성공 : 1
	*/
	
	@RequestMapping("1")
	public String quiz03_1(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price
			) {
		int rowCount = realestateBo.updateRealEstateByID(id, type, price);
		return "변경 완료 : " + rowCount;
	}
	
}
