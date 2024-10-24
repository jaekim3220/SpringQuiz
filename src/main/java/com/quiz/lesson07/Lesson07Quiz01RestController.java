package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

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
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {
	
	// CRUD 구현
	
	@Autowired
	private CompanyBO companyBO;
	
	/*
	company 테이블을 통해서 아래 문제를 풀어 보세요.
	1. Create
	아래 회사 정보를 테이블에 Insert 하세요.
	객체 생성은 builder 패턴을 활용하세요.
	저장 성공한 객체들의 정보를 아래와 같이 출력하세요.
	
	/lesson07/quiz01/save1
	회사명 : 넥손
	사업내용 : 컨텐츠 게임
	규모 : 대기업
	사원수 : 3585명
	
	출력 결과
	{
	      "id": 1,
	      "name": "넥손",
	      "business": "컨텐츠 게임",
	      "scale": "대기업",
	      "headcount": 3585,
	      "createdAt": "202x-06-01T20:17:50.9305192+09:00",
	      "updatedAt": "202x-06-01T20:17:50.9305192+09:00"
	}
	*/
	
	// C : create
	@GetMapping("/save1")
	// localhost/lesson07/quiz01/save1
	public CompanyEntity save1() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		// save된 객체를 return하므로 id가 채워져있음
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	/*
	/lesson07/quiz01/save2
	회사명 : 버블팡
	사업내용 : 여신 금융업
	규모 : 대기업
	사원수 : 6834명
	*/
	
	// C : create
	@GetMapping("/save2")
	// localhost/lesson07/quiz01/save2
	public CompanyEntity save2() {
		
		// save된 객체를 return하므로 id가 채워져있음
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}

	
	/*
	2. Update
	/lesson07/quiz01/update

	버블팡이 극심한 경영 악화로 회사 정보가 변경되었다.
	규모를 중소기업, 사원수를 34명 으로 수정하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
	*/
	
	@GetMapping("/update")
	// http://localhost/lesson07/quiz01/update
	public CompanyEntity update() {
		// id가 9번인 버블팡을 중소기업, 사원수 34명으로 변경
		
		return companyBO.updateCompanyById(9, "중소기업", 34);
	}
	
	
	/*
	3. Delete
	/lesson07/quiz01/delete

	버블팡이 파산하여 회사가 없어졌다.
	해당 회사 정보를 테이블에서 삭제하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
	*/
	
	@GetMapping("/delete")
	// http://localhost/lesson07/quiz01/delete
	public String delete() {
		// id 9번 삭제
		companyBO.deleteCompanyById(9); // 호출
		return "수행완료";
	}
	
}
