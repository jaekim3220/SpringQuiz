package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.WeatherHistory;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface WeatherHistoryMapper {

	
	// input : X
	// output : List<WeatherHistory>
	// 5-5.1 : 날씨 정보 페이지
	public List<WeatherHistory> selectWeatherHistoryList();
	
	
	// input : weather_history 데이터
	// output : int or void
	// 5-5.2 : 날씨 입력 페이지
	public void insertWeatherHistory(
			@Param("date") String date, 
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,  
			@Param("microDust") String microDust, 
			@Param("windSpeed") double windSpeed);
	
}
