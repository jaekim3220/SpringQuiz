package com.quiz.lesson07.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자(기본)
@Builder(toBuilder = true) // Setter 대용 + update를 위해 toBuilder 추가, 필드 수정 허용
@Getter // Getter
@Entity // JPA 엔티티 객체. DB-JPA 통신(사용하려면 lombok이 필요)
@Table(name = "recruit") // JPA 엔티티 객체(사용하려면 lombok이 필요)
public class RecruitEntity {

	// 속성 : field(`recruit` 테이블)
	@Id // PK 식별자
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert 이후 방금 들어간 id 가져옴
	
	private int id;
	
	@Column(name="companyId") // 카멜 케이스 설정
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private Date deadline;
	
	@CreationTimestamp // 값이 null 이어도 insert 되는 시간으로 설정
	@Column(name="createdAt") // 카멜 케이스 설정
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // insert, update 일 경우 해당 시간으로 설정
	@Column(name="updatedAt") // 카멜 케이스 설정
	private LocalDateTime updatedAt;
	
}
