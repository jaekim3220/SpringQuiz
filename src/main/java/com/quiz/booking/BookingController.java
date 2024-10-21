package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

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

@Controller
@RequestMapping("/lesson06/quiz03")
public class BookingController {

	
	/*
	html 경로: /templates/booking/bookingList
	html 경로: /templates/booking/makeBooking
	html 경로: /templates/booking/checkBooking
	URL Path: /booking/booking-list-view
	URL Path: /booking/make-booking-view
	URL Path: /booking/check-booking-view
	*/
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private BookingBO bookingBO;
	
	
	/*
	1. 예약 목록
	booking 테이블의 데이터를 활용해서 페이지를 완성하세요.
	삭제 기능은 AJAX로 구현하세요.
	`booking` 테이블을 사용
	*/
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// DB SELECT Service(BO)영역
		List<Booking> bookingList = bookingBO.selectBookingList();
		
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	
	
}
