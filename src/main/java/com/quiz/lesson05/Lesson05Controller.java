package com.quiz.lesson05;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	
	// 5-1 : Thymeleaf `변수와 조건문`
	
	@GetMapping("/quiz01")
	public String quiz01() {
		return "lesson05/quiz01";
	}
	
	
	// 5-2 : Thymeleaf `반복문`
	
	@GetMapping("/quiz02")
	public String quiz02(Model model) {
		
		/*
		1. 반복문
		가요 순위 HOT5를 List에 저장 후
		해당 리스트를 컨트롤러에서 Model을 통해서 html에 전달하고, 아래와 같은 화면을 구성하세요.
		bootstrap을 사용하세요.
		*/
		
		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("강남스타일");
		musicRanking.add("벚꽃엔딩");
		musicRanking.add("좋은날");
		musicRanking.add("거짓말");
		musicRanking.add("보고싶다");
		
		model.addAttribute("musicRanking", musicRanking);
		
		
		/*
		2. 반복문과 조건
		이름, 전화번호, 등급, 포인트가 저장되어 있는 리스트 맵을 생성 후
		해당 리스트 맵을 컨트롤러에서 Model을 통해서 html에 전달하고, 아래와 같은 화면을 구성하세요.
		등급이 VIP인 경우 글씨를 빨간색으로, 등급이 GOLD인 경우 노란색으로 표시하세요.
		포인트가 5000점 이상이면 포인트를 파란색으로 표시하세요.
		*/
		
		List<Map<String, Object>> membership = new ArrayList<>();

		Map<String, Object> member = new HashMap<>();
		member.put("name", "손오공");
		member.put("phoneNumber", "010-1234-5678");
		member.put("grade", "VIP");
		member.put("point", 12040);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "저팔계");
		member.put("phoneNumber", "010-4321-1234");
		member.put("grade", "BASIC");
		member.put("point", 3420);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "사오정");
		member.put("phoneNumber", "010-8888-1111");
		member.put("grade", "GOLD");
		member.put("point", 1530);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "삼장");
		member.put("phoneNumber", "010-0000-1234");
		member.put("grade", "GOLD");
		member.put("point", 8450);
		membership.add(member);

		member = new HashMap<>();
		member.put("name", "우마왕");
		member.put("phoneNumber", "010-1111-2222");
		member.put("grade", "BASIC");
		member.put("point", 420);
		membership.add(member);
		
		model.addAttribute("membership", membership);
		
		return "lesson05/quiz02";
	}
}
