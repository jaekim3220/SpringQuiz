package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

//일반 JAVA Bean : Spring이 관여 안 함(데이터를 담는 공간)
public class Data {

	// 속성 : field
	private Map<String, Object> map = new HashMap<>();

	
	// 기능 : 메서드
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	// Constructor/Setter
	
	
}
