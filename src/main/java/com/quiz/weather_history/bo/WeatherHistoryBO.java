package com.quiz.weather_history.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input : X
	// output : List<WeatherHistory>
	// 5-5.1 : 날씨 정보 페이지
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	
	
	// input : weather_history 데이터
	// output : int or void
	// 5-5.2 : 날씨 입력 페이지
	public void addWeatherHistory(
			// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
			String date, String weather, double temperatures,
			double precipitation, String microDust, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
	
}
