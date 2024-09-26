package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

//일반 JAVA Bean : Spring이 관여 안 함(데이터를 담는 공간)
public class Board {

	// 속성 : field
	private Object title;
	private Object user;
	private Object content;
	
	
	// 기능 : 메서드
	public Object getTitle() {
		return title;
	}
	public void setTitle(Object title) {
		this.title = title;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}

	
	// Constructor/Setter
	
	
}
