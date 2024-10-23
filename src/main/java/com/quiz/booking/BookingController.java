package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/booking")
public class BookingController {

	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private BookingBO bookingBO;
	
	
	/*
	1. 예약 목록
	booking 테이블의 데이터를 활용해서 페이지를 완성하세요.
	삭제 기능은 AJAX로 구현하세요.
	`booking` 테이블을 사용
	*/
	
	// http:localhost:80/booking/booking-list-view
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
	
	// 삭제 기능
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id
			) {
		// DB DELETE
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값 => JSON : breakPoint
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 대상이 없습니다.");
		}
		
		return result;
	}
	
	
	
	/*
	2. 예약하기 페이지
	예약하기 페이지에서 기본 유효성 검사를 포함 시키세요.
	날짜 선택은 datepicker를 이용하세요.
	예약 하기 기능은 AJAX로 구현하세요.
	*/
	
	// http:localhost:80/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		
		return "booking/makeBooking";
	}
	
	// 예약 기능
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		// DB INSERT
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		
		// Response - JSON : breakpoint
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	
	/*
	3. 예약 조회 기능
	통나무펜션 페이지를 활용해서 예약 조회 기능을 만드세요.
	이름과 전화번호를 입력 받고, 이를 통해서 예약 내역을 조회하세요.
	조회 기능은 AJAX로 구현하세요.
	조회가 될 경우 아래와 같이 얼럿창을 띄워서 예약 내역을 출력하세요.
	조회가 안 될 경우 예약 내역이 없습니다를 출력하세요.
	*/
	
	// http:localhost:80/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	
	// 조회 기능
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB SELECT
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
		
		
		// RESPONSE - JSON : breakpoint
		// {"code":200, "result":booking}
		// {"code":200, "result":{"id":3, "name":"김재현" ...}}
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			result.put("result", booking);			
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		
		return result;
	}
	
	
}
