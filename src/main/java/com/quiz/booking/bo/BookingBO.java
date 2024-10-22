package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class BookingBO {
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private BookingMapper bookingMapper;

	
	// input : X
	// output : Booking or Null
	// 6-3.1 예약 목록
	public List<Booking> selectBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input : id
	// output : int(성공한 행의 개수)
	// 6-3.1 예약 목록 삭제
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	

	// input : X
	// output : Booking or Null
	// 6-3.2 예약하기 페이지
	public void addBooking(
			String name,
			LocalDate date,
			int day,
			int headcount,
			String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	
	// input : X
	// output : Booking or Null
	// 6-3.3 예약 조회 기능
}
