package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
public class WeatherHistoryController {
	
	
	@GetMapping("/weather-list-view")
	public String weatherListView() {
		
		return "weather_history/weatherList";
	}
	

	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		return "weather_history/addWeather";
	}
}
