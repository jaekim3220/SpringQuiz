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
	
}
