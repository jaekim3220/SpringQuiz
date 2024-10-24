package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

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

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	// CRUD 구현 - SELECT
	
	// BO 생략
	@Autowired
	private RecruitRepository recruitRepository;
	
	/*
	1. id 로 조회(/lesson07/quiz02/1)
	id가 8인 공고를 조회하세요.
	*/
	
	@GetMapping("/1")
	// http://localhost/lesson07/quiz02/1
	public RecruitEntity quiz02_1() {
		// 단건 조회(List 아님)
		return recruitRepository.findById(8).orElse(null); // 내장 메서드
	}
	
	
	/*
	2. Parameter 조건 조회 (/lesson07/quiz02/2)
	Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
	*/
	
	@GetMapping("/2")
	// http://localhost/lesson07/quiz02/2
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
	
	/*
	3. 복합 조건 조회 (/lesson07/quiz02/3)
	웹 back-end 개발자 이고 정규직인 공고를 조회하고 출력하세요.
	*/
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	
	/*
	4. 복합 조건 조회(/lesson07/quiz02/4)
	정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	메소드명 규칙을 검색해서 찾아보세요.
	*/
	
	
	/*
	5. 정렬 제한 조건(/lesson07/quiz02/5)
	계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	*/
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz02_5() {
		return recruitRepository.findTop3ByOrderBySalaryDesc();
	}
	
	
	/*
	6. 범위 조회 (/lesson07/quiz02/6)
	성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	*/
	
	@GetMapping("/6")
	public List<RecruitEntity> quiz02_6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
}
