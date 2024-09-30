package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface RealEstateMapper {

	// input : None. BO(Service)한테 받아옴.
	// output : BO한테 돌려줌. Review 단건. 없으면 null.
	public RealEstate selectEstateById(int id);
	
	public List<RealEstate> RentPriceList(Integer rent_price);
}
