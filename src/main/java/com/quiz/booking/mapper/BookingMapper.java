package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper
public interface BookingMapper {

	// input : X
	// output : Booking or Null
	// 6-3.1 예약 목록
	public List<Booking> selectBookingList();
	
	// input : id
	// output : int(성공한 행의 개수)
	// 6-3.1 예약 목록 삭제
	public int deleteBookingById(int id);

	
	// input : X
	// output : Booking or Null
	// 6-3.2 예약하기 페이지
	public void insertBooking(
			// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("name") String name,
			@Param("date") LocalDate date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);

	
	
	// input : X
	// output : Booking or Null
	// 6-3.3 예약 조회 기능
}
