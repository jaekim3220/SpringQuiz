package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	
	
	// input : name, phoneNumber
	// output : Booking(최신 1개) or null
	// 6-3.3 예약 조회 기능
	// 가져오는 행이 여러 개 (BookmarkBO 참고)
	// BO에서 가공하지 않고 XML에서 ORDER BY, LIMIT 문을 사용해 가공할 수도 있음
	public Booking getLatestBookingByNamePhoneNumber(
			String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		// [1, 2, ...] or [1]
		// []
		
		/*
		if (bookingList.isEmpty()) {
			return null;
		}
		
		return bookingList.get(bookingList.size() - 1); // 마지막 칸은 요소 개수 - 1
		*/
		
		// 삼항 연산자화
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
	
}
