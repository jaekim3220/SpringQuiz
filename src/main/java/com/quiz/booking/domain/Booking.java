package com.quiz.booking.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Controller영역(Domain)

// 일반 JAVA BEAN
// DTO(Data Transfer Object), Domain, Model, Entity(결과)

@Data
public class Booking {

	// 속성 : field(`booking` 테이블)
	private int id;
	private String name;
	private int headcount;
	private int day;
	private LocalDate date;
	private String phoneNumber;
	private String state;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
}
