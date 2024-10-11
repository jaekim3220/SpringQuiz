package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.domain.Seller;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

/*
@Controller + return String => HTML경로 => HTML
@Controller + @ResponseBody return map => JSON
@RestController return map => JSON
*/
@RequestMapping("/lesson04/quiz02")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Quiez02Controller {
	
	
	@Autowired
	private RealtorBO realtorBo;
	
	/*
	1. 공인중개사 추가
	입력 form을 이용해서 새로운 공인중개사를 DB에 추가하세요.
	@ModelAttribute 를 이용해서 parameter를 받으세요.
	submit 후 useGeneratedKeys 를 이용해서 insert한 내용의 id를 얻어내고 이를 이용해서 새롭게 select 하고 그 결과를 출력하세요.
	입력 form URL : /lesson04/quiz02/add-realtor-view
	입력 action URL : /lesson04/quiz02/add-realtor
	*/
	
	@GetMapping("/add-realtor-view")
	public String addRealtorVeiw() {
		
		return "lesson04/addRealtor"; // VIEW(HTML) 경로
	}
	
	
	// 공인중개사 추가 => 최신 가입자
	// 입력, 수신한 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, // form 태그의 name과 field가 일치하면 세팅됨 (Domain에서 가져옴)
			Model model) {
		
		
		// DB에 삽입(INSERT)
		realtorBo.addRealtor(realtor);
		
		
		// DB SELECT
		int id = realtor.getId();
		Realtor latestRealtor = realtorBo.getRealtorById(id);
		
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("realtor", latestRealtor);
		
		
		// VIEW로 이동
		return "lesson04/afterAddRealtor"; // VIEW(HTML) 경로
	}

}
