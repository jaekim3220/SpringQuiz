package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01") // 클래스에 있는 path를 먼저 읽어 들인다.
@Controller // Spring Bean 등록
public class Lesson01Quiz01Controller {

	/*1-1 문제 : httpMessageConverter와 어노테이션 (1)*/
	
	
	/*
	1. String 출력하기
	String return을 통해서 간단한 화면을 구성하세요.
	요청 URL : http://localhost:8080/lesson01/quiz01/1
	*/
	
	// http:localhost:8080/lesson01/quiz01/1
	// String을 브라우저에 출력
	@RequestMapping("/1")
	@ResponseBody // return되는 String은 ResponseBody에 넣어지고 HTML 응답
	public String quiz01_1() {
		return "<h2>텍스트 프로젝트 완성</h2>"
				+ "<h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</h3>";
	}
	
	
	/*
	2. Map JSON 출력
	Map을 통해서 json 데이터를 출력하세요.
	요청 URL : http://localhost:8080/lesson01/quiz01/2
	*/
	
	 
	@RequestMapping("/2")
	// return되는 Map은 ResponseBody에 넣어지고 JSON으로 응답
	public @ResponseBody Map<String, Object> quiz01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		
		// map을 return하면 JSON String이 출력 된다.
		// web starter에 `jack`이라는 라이브러리가 존재하기 때문.
		return map;
	}
	
	
}
