package com.quiz.lesson03;

import java.util.List;

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
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {

	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private RealEstateBo estateBo;

	
	/*
	1. id 로 select 하기
	id를 parameter 로 입력 받고 해당하는 id의 매물 정보를 JSON Response로 브라우저에서 출력하세요.
	
	요청 Path 예시
	/lesson03/quiz01/1?id=20
	*/
	
	// http:localhost:80/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			// parameter 설정
			
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			// @RequestParam("id") int id
			
			// 필수 파라미터 불러오기2
			// @RequestParam(value = "id", required = true) int id
			
			// 필수 파라미터 불러오기3
			// @RequestParam(value = "id") int id
			
			// 비필수 파라미터 불러오기1
			 // @RequestParam(value = "id", required = false) Integer id
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			 @RequestParam(value = "id", defaultValue = "1") int id // 기본값 : 1
			) {
//		if (id == null) {
//			id = 1;
//		}
		return estateBo.getEstate(id);
	}
	
	
	/*
	2. 월세 조건 select
	월세(rentPrice) 를 parameter 로 받고 해당하는 월세보다 낮은 매물을 아래와 같이 json 으로 출력하세요.
	
	요청 Path 예시
	/lesson03/quiz01/2?rent_price=90
	*/
	
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			// parameter 설정
			
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("rent_price") Integer rent_price
			
			// 필수 파라미터 불러오기2
			// @RequestParam(value = "rent_price", required = true) double rent_price
			
			// 필수 파라미터 불러오기3
			// @RequestParam(value = "rent_price") double rent_price
			
			// 비필수 파라미터 불러오기1
			// @RequestParam(value = "rent_price", required = false) Double rent_price
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			// @RequestParam(value = "rent_price", defaultValue = "200") double rent_price // 기본값 : 1
			) {
//		if (rent_price == null) {
//			rent_price = (double) 200;
//		}
		return estateBo.getEstate(rent_price);
	}
	
	
	/*
	3. 복합조건 select
	아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
	넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
	가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
	등록일을 기준으로 내림 차순으로 정렬하세요.
	
	요청 Path 예시
	/lesson03/quiz01/3?area=90&price=130000
	*/
	
//	@RequestMapping("/3")
//	public 
}
