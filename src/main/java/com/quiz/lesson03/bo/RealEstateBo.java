package com.quiz.lesson03.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	private RealEstateMapper realestateMapper;
	
	// input : int(id)
	// output : 컨트롤러한테 제공. Estate 단건. 없으면 null.
	// lesson03 MyBatis 1-1 문제
	public RealEstate getRealEstateById(int id) {
		return realestateMapper.selectRealEstateById(id);
	}
	
	// lesson03 MyBatis 1-2 문제
	public List<RealEstate> getRentPriceListByRentPrice(int rent_price) {
		return realestateMapper.selectRealEstateListByRentPrice(rent_price);
	}
	
	// lesson03 MyBatis 1-3 문제
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realestateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	
	// input : RealEstate(테이블)
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 2-1 문제 : 객체로 insert 하기
	public int addRealEstate(RealEstate realEstate) {
		return realestateMapper.insertRealEstate(realEstate);
	}
	
	// input : Parameter들
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 2-2 문제 : field 로 insert 하기
	public int addRealEstateAsField(
			int realtorId,
			String address, 
			int area, 
			String type,
			int price, 
			Integer rentPrice) {
		
		return realestateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
}
