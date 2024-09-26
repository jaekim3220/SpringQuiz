package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 이동
@Controller // spring bean 등록, HTML로 보낼 때는 @ResponseBody가 절대 있으면 안됨!
public class Lesson01Quiz03Controller {

	
	/*
	1. ViewResolver html 연동
	html을 활용해서 화면을 만들고 ViewResolver를 통해서 출력하세요.
	요청 URL : http://localhost:8080/lesson01/quiz03/1
	html 파일 경로: templates/lesson01/quiz03.html
	*/
	
	
	// 요청 URL : http://localhost:80/lesson01/quiz03
	@RequestMapping("/lesson01/quiz03") // request 요청
	public String quiz02() {
		// return되는 String은 HTML의 `경로`.
		// @ResponseBody가 없어야 한다.
		
		// templates/	lesson01/quiz03.html
		return "lesson01/quiz03";
	}
	
}
