package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

import jakarta.servlet.http.HttpServletResponse;

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

@RequestMapping("/weather_history")
@Controller // HTML 경로일 경우 @ResponseBody가 부재
public class WeatherHistoryController {
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private WeatherHistoryBO weatherHistoryBo;
	
	
	/*
	1. 날씨 정보 페이지
	weather_history table을 활용해서 아래와 같은 페이지를 만드세요.
	JSTL을 활용해서 날짜 포맷을 맞춰서 출력하세요.
	기상청 로고는 인터넷에서 이미지 링크를 구해서 사용하세요.
	날씨에 맞는 이미지를 표시하세요. (이미지는 아래 링크 활용)
	*/
	
	// http:localhost:80/weather_history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// DB SELECT Service(BO)영역
		List<WeatherHistory> weatherHistoryList = weatherHistoryBo.getWeatherHistoryList();
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	

	/*
	2. 날씨 입력 페이지
	날씨 정보를 입력 받고 DB에 저장 하는 아래와 같은 페이지를 만드세요.
	입력이 성공한 뒤에는 위에서 만든 날씨 정보 페이지로 redirect 시키세요.
	datepicker 라이브러리를 사용해보세요.
	*/
	
	// 정보 일벽 페이지
	// http:localhost:80/weather_history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		return "weather_history/addWeather";
	}
	
	
	// 입력 후 페이지(DB에 저장 => 목록화면)
	@PostMapping("/add-weather")
	public String addWeather(
			// 1. field(Parameter)로 insert 하기 (lesson03 insert) - parameterType = map
			// @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("date") String date, // String으로 날짜를 받는게 편함
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed
			// 2. 객체로 insert 하기 (lesson03 insert) - parameterType = Domain
			// 3. @ModelAttribute에 객체 저장 후 insert (lesson04-2)
			) {

		// DB에 INSERT
		weatherHistoryBo.addWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		
		// 목록 화면으로 이동
		// 1. public void addWeather일 경우
		// HttpServletResponse response
		// response.sendRedirect("/weather_history/add-weather-view");
		return "redirect:/weather_history/weather-list-view";
	}
}
