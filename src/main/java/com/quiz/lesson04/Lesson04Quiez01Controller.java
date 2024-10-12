package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

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
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 입력, 수신한 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-seller")
	public String addSeller(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천) - null이 아닌 column
			@RequestParam("nickname") String nickname,
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature
			) {
		
		// DB INSERT
		sellerBo.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면 이동
		return "lesson04/afterAddSeller";
	}
	
	
	/*
	2. seller 출력
	가장 최근에 추가된 seller의 정보를 아래와 같은 형태로 출력 하세요.
	요청 URL : /lesson04/quiz01/seller-info-view
	
	3. seller 검색 출력
	2번 문제에서 만든 컨트롤러의 메소드를 재사용해서 id를 parameter로 받아서 해당하는 seller를 출력하세요.
	id parameter가 없는 경우와 있는 경우 모두 처리 가능하도록 구현하세요.
	*/
	
	// http:localhost:80/lesson04/quiz01/seller-info-view
	// 추가 : http:localhost:80/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			@RequestParam(value = "id", required = false) Integer id, // 3. seller 검색 출력
			Model model) {
		
		// DB SELECT Service(BO)영역
		
		// 비필수 파라미터 불러오기2 : 기본값 설정 (추천) // 3. seller 검색 출력
		// id가 null이면 최신으로, id가 있으면 id로 return
		Seller seller = null;
		if (id == null) {
			seller = sellerBo.getLatestSeller();
		} else {
			seller = sellerBo.getSellerById(id); 
		}
		
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		
		return "lesson04/sellerInfo"; // HTML(VIEW) 경로
	}
	
	
}
