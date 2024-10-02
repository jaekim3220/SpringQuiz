package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface RealEstateMapper {

	// input : int(id). BO(Service)한테 받아옴.
	// output : BO한테 돌려줌. Review 단건. 없으면 null.
	// lesson03 MyBatis 3-1 문제1
	public RealEstate selectRealEstateById(int id); // 단건이므로 RealEstate
	
	// input : int(rentPrice)
	// output : 다건(List<RealEstate>). 없으면 null.
	// lesson03 MyBatis 3-1 문제2
	public List<RealEstate> selectRealEstateListByRentPrice(int rent_price); // 다건이므로 List
	
	// input : int(price), int(area).
	// output : 다건(List<RealEstate>). 없으면 null.
	// lesson03 MyBatis 3-1 문제3
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("area") int area, 
			@Param("price") int price); // 다건이므로 List
	
	
	// input : RealEstate(테이블)
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 3-2 문제1 : 객체로 insert 하기
	public int insertRealEstate(RealEstate realEstate);
	
	// input : Parameter들
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 3-2 문제2 : field 로 insert 하기
	public int insertRealEstateAsField(
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("realtorId") int realtorId,
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type,
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	
	// input : id, type, price
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 3-3 문제 : update
	public int updateRealEstateById(
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	
	// input : id
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// lesson03 MyBatis 3-4 문제 : delete
	public int deleteRealEstateById(int id);
	
}

