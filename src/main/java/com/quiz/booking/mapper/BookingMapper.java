package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	
	
}
