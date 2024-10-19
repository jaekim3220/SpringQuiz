package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

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
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

	
	/* 6-1 연습문제 : AJAX 통신으로 서버 요청*/
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private BookmarkBO bookmarkBO;
	
	
	/*
	1. AJAX 통신으로 submit 대신 서버 요청
	bookmark 테이블을 이용하세요.
	입력 화면을 통해서 새로운 즐겨 찾기 목록을 추가하세요.
	모든 칸에 입력되었는지 validation 코드를 추가하세요.
	http 또는 https 프로토콜까지 모두 입력되었는지 validation 코드를 추가하세요.
	form submit 을 사용하지 않고 ajax 를 이용해서 수행하세요.
	*/
	
	// 북마크 추가 화면
	// http:localhost:80/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkVeiw() {
		return "lesson06/addBookmark";
	}
	
	
	// 북마크 추가 진행 => AJAX 요청
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB INSERT ★★★ breakpoint 1 ★★★
		// Model은 HTML일 경우 사용(@ResponseBody일 경우 Model 사용 불가)
		bookmarkBO.addBookmark(name, url);
		
		// 성공 여부 JSON String ★★★ breakpoint 2 ★★★
		// "{"code":200, "result":"성공"}" 형식
		// 사용하기 위해서는 JSON을 Dictionary 형식으로 바꿀 필요가 있음
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	/*
	2. 결과 페이지 이동
	입력 성공 이후에 리스트 화면으로 이동하세요.
	*/
	
	// 즐겨찾기 목록
	// http:localhost:80/lesson06/quiz01/bookmark-list-view
	@GetMapping("/bookmark-list-view")
	public String bookMarkListView(Model model) {
		
		// DB SELECT Service(BO)영역
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
}
