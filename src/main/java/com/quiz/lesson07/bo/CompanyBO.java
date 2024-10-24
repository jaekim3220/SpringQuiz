package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class CompanyBO {

	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private CompanyRepository companyRepository;
	
	// JPA
	// input : 4개 parameter
	// ouput : CompanyEntity
	// JPA - Create
	public CompanyEntity addCompany(
			String name, String business,
			String scale, int headcount) {
		
		/*
		CompanyEntity company = CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build(); // @CreationTimestamp 있으면 생략 가능
		*/
		
		// 중간저장(변수) 없음
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	
	// input : 3개 parameter (id, scale, headcount)
	// output : CompanyEntity
	// JPA - Update
	public CompanyEntity updateCompanyById(
			int id, String scale, int headcount) {
		// 기존 데이터 조회 - id로 entity 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// update - JPA는 save 메서드를 사용(INSERT, UPDATE)
		// 조회된 데이터가 존재할 때 업데이트 진행
		if (company != null) {
			
			// 변경할 내용을 엔티티에 설정 후 save(id가 존재) update
			company = company.toBuilder()
			.scale(scale)
			.headcount(headcount)
			.build();
			company = companyRepository.save(company);
		}
		
		return company;
		
	}
	
}
