package com.quiz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring Bean 등록
public class TestController {

	// String을 브라우저에 출력
	@RequestMapping("/test") // 주소 경로 설정
	@ResponseBody // return되는 String은 Response Body에 넣어지고 HTML응답
	public String test() {
		return "Hello World Quiz!!";
	}
	
}
