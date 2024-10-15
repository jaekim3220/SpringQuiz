package com.quiz.lesson05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.domain.Member;

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
	
	
	// 5-3 : Thymeleaf `날짜 형태와 String`
	@GetMapping("/quiz03")
	public String quiz03(Model model) {
		
		/*
		회원 정보를 저장 후 Member Class를 설계하세요.
			이름, 생년월일, 전화번호, 국적, 이메일, 자기소개
			
		해당 리스트를 컨트롤러에서 Model을 통해서 html에 전달하고, 화면을 구성하세요.
		
		생년월일을 OOO년 O월 O일 형태로 출력하세요.
		국적의 삼국시대 를 삼국 - 형태로 변경하세요.
		이메일 주소의 id 부분을 굵게 표시하세요.
		전화번호가 010 으로 시작하지 않으면 유효하지 않은 전화번호라고 표시하세요.
		자기소개의 내용을 15자까지 표시하세요.
		자기소개가 15자가 넘어갈 경우 뒤에 ... 을 표시하세요.
		*/
		
		List<Member> members = new ArrayList<>();

		Member member = new Member();
		member.setName("유비");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("youbee@gmail.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("저는 촉의 군주 유비입니다. 삼국통일을 위해 열심히 일하겠습니다.");
		member.setBirth(LocalDate.of(161, 7, 9));
		members.add(member);

		member = new Member();
		member.setName("관우");
		member.setPhoneNumber("010-1234-5678");
		member.setEmail("woo@naver.com");
		member.setNationality("삼국시대 촉한");
		member.setIntroduce("관우에요. 저는 유비형님 보다 나이는 많지만 일단 아우입니다.");
		member.setBirth(LocalDate.of(160, 6, 14));
		members.add(member);

		member = new Member();
		member.setName("장비");
		member.setPhoneNumber("02-111-3333");
		member.setNationality("삼국시대 촉한");
		member.setEmail("tools@gmail.com");
		member.setIntroduce("장비라우");
		member.setBirth(LocalDate.of(165, 1, 31));
		members.add(member);

		member = new Member();
		member.setName("조조");
		member.setPhoneNumber("010-0987-4321");
		member.setNationality("삼국시대 위");
		member.setEmail("jojo@gmail.com");
		member.setIntroduce("이름은 조조 자는 맹덕이라 하오");
		member.setBirth(LocalDate.of(155, 5, 3));
		members.add(member);

		member = new Member();
		member.setName("주유");
		member.setPhoneNumber("010-0000-1111");
		member.setNationality("삼국시대 오");
		member.setEmail("jooyou@kakao.com");
		member.setIntroduce("주유는 주유소에서 ㅋㅋ");
		member.setBirth(LocalDate.of(175, 5, 10));
		members.add(member);

		member = new Member();
		member.setName("황충");
		member.setPhoneNumber("031-432-0000");
		member.setNationality("삼국시대 촉한");
		member.setEmail("yellowbug@naver.com");
		member.setIntroduce("내 수염 좀 멋있는 듯");
		member.setBirth(LocalDate.of(143, 8, 22));
		members.add(member);

		model.addAttribute("members", members);
		
		
		return "lesson05/quiz03";
	}
	
}
