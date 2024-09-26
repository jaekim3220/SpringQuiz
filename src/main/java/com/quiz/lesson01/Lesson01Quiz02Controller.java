package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController // @Controller + @ResponseBody
// @Controller : Spring Bean 등록, @ResponseBody : return되는 값을 저장 => Json String으로 응답
public class Lesson01Quiz02Controller {

	/*1-2 문제 : httpMessageConverter와 어노테이션 (2)*/
	
	
	/*
	1. json 출력 (List, Map)
	영화 정보를 저장한 json을 List와 Map을 활용해서 출력하세요.
	요청 URL : http://localhost:8080/lesson01/quiz02/1
	*/
	
	// 본인 풀이
	@RequestMapping("/1")
	public List quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");

		list.add(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");

		list.add(map2);
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("12", 15);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");

		list.add(map3);
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");

		list.add(map4);
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");

		list.add(map5);
		
		return list;
	}
	
	// 모범 답안
	@RequestMapping("/11")
	public List quiz02_11() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");

		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");

		list.add(map);
		
		map = new HashMap<>();
		map.put("12", 15);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");

		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");

		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");

		list.add(map);
		
		return list;
	}
	
	
	/*
	2. json 출력 (List, Class)
	게시판 내용을 저장한 json을 List 와 Class 를 설계하고 활용해서 출력하세요.
	요청 URL : http://localhost:8080/lesson01/quiz02/2
	*/
	
	// 본인 풀이
	@RequestMapping("/2")
	public List quiz02_2() {
		List<Data> list = new ArrayList<>();
		
		Data map1 = new Data();
		Map<String, Object> data1 = new HashMap<>();
		data1.put("title", "안녕하세요 가입인사 드립니다.");
		data1.put("user", "marobiana");
		data1.put("content", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		map1.setMap(data1);
		
		Data map2 = new Data();
		Map<String, Object> data2 = new HashMap<>();
		data2.put("title", "헐 대박");
		data2.put("user", "bada");
		data2.put("content", "오늘 목요일이었어... 금요일인줄");
		map2.setMap(data2);
		
		Data map3 = new Data();
		Map<String, Object> data3 = new HashMap<>();
		data3.put("title", "오늘 데이트 한 이야기 해드릴게요.");
		data3.put("user", "dulumary");
		data3.put("content", "...");
		map3.setMap(data3);
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		return list;
	}
	
	// 모범답안
	@RequestMapping("/21")
	public List quiz02_21() {
		// @ResponseBody + return String => HttpMessageConverter => HTML
		// @ResponseBody + return 객체 => HttpMessageConverter => Jackson Library로 동작 => JSON 동작
		
		List<Board> list = new ArrayList<>();
		
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		list.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일이었어... 금요일인줄");
		
		list.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		board.setUser("dulumary");
		board.setContent("...");

		list.add(board);
		
		return list;
	}
	
	
	/*
	3. ResponseEntity
	게시글 내용을 하나만 json 으로 출력하세요.
	ResponseEntity 를 이용해서 HttpStatus.INTERNAL_SERVER_ERROR 로 상태 코드를 전달하세요.
	*/
	
	// 본인 풀이 (list에 저장된 데이터 중 하나를 random 하게 가져온다.)
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		
		List<Board> list = new ArrayList<>();
		list = quiz02_21();
		
		Random rand = new Random();
		int randIndex = rand.nextInt(list.size());
		
		Board randBoard = list.get(randIndex);
		return new ResponseEntity<>(randBoard, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 모범답안
	@RequestMapping("/31")
	public ResponseEntity<Board> quiz02_31() {
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
