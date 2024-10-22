package com.quiz.lesson06.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper
public interface BookmarkMapper {

	
	// input : 파라미터 2개
	// output : int or void
	// 6.1.2 입력 페이지
	public void insertBookmark(
			@Param("name") String name,
			@Param("url") String url);
	
	// input : X
	// output : Bookmark or Null
	// 6.1.2 결과 페이지
	public List<Bookmark> selectBookmarkList();
	
	
	// input : url
	// output : boolean t:중복 f:중복 아님
	// 6.2.1 북마크 추가 화면
	public boolean isDuplicatedUrl(String url);
	
	
	// input : url
	// output : Bookmark 행
	// 6-2 URL 중복확인 - AJAX 요청
	// Bookmark 행 하나가 아닌 중복된 조건 여러 행을 가져오기 때문에 List 형식
	public List<Bookmark> selectBookmarkByUrl(String url);
	
	
	// input : int id
	// output : 성공한 행의 수 int
	// 6-2 URL 중복확인 - AJAX 요청(DELETE)
	public int deleteBookmarkById(int id);
}
