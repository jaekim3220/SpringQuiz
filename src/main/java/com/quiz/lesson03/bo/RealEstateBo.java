package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

//Service(BO)영역

@Service // Spring Bean 등록
public class RealEstateBo {

	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private RealEstateMapper estateMapper;
	
	// input : None. 컨트롤러(Domain)한테 받는다
	// output : 컨트롤러한테 제공. Estate 단건. 없으면 null.
	public RealEstate getEstate(int id) {
		return estateMapper.selectEstateById(id);
	}
	
	public List<RealEstate> getEstate(Integer rent_price) {
		return estateMapper.RentPriceList(rent_price);
	}
	
}
