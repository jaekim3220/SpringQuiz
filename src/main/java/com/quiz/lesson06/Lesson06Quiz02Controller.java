package com.quiz.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

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

@Controller
@RequestMapping("/lesson06/quiz02")
public class Lesson06Quiz02Controller {
	
	
	/* 6-2 연습문제 : AJAX로 중복확인*/
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private BookmarkBO bookmarkBO;
	
	
	/*
	1. AJAX로 동적 태그 추가 - 주소 중복 확인
	AJAX로 submit 대신 웹 요청하기 문제 페이지를 재사용 해서 문제를 해결하세요.
	url 입력 옆에 중복확인 버튼을 위치 시키세요.
	ajax를 통해서 현재 DB에 중복되어 있는 url 이 있는지 화면에 표시하세요.
	중복이 되었을 경우 중복된 url 입니다, 중복이 안되었을 경우 저장 가능한 url 입니다. 를 표시하세요.
	*/
	
	// 북마크 추가 화면
	// http:localhost:80/lesson06/quiz02/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkVeiw() {
		return "lesson06/addBookmark2";
	}
	
	
	// AJAX 요청
	@ResponseBody
	@GetMapping("/is-duplicated-url")
	public Map<String, Object> isDuplicatedUrl(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천) - null이 아닌 column
			@RequestParam("name") String name, 
			// String name 넣으면 data:{"name":name,"url":url}해야 중복 체크가 가능
			@RequestParam("url") String url) {
		
		
		// DB SELECT ★★★ breakpoint 2 ★★★
		boolean isDuplicated = bookmarkBO.isDuplicatedUrl(url);
		

		// 성공 여부 JSON String ★★★ breakpoint 1 ★★★
		// 응답값 => Map => JSON String
		// {"code":200, "is_duplicated_url":true}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated_url", isDuplicated);
		
		
		// DB INSERT
		// bookmarkBO.addBookmark(name, url);

		return result;
	}
	
	
	/*
	2. 삭제 기능 - 고급 문제
	즐겨찾기 목록 화면에 모든 행에 삭제 버튼을 위치 시키세요.
	해당 버튼을 눌렀을 때 ajax를 통해서 해당 행을 DB에서 삭제하고, 성공 후에 화면을 새로고침 하세요.
	`삭제버튼은 button + ajax 요청 + post로 요청`
	*/
	


}
