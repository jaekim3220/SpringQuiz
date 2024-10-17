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

	
	// input : 파라미터 4개
	// output : X
	// 6.1.2 입력 페이지
	public void insertBookmark(
			@Param("name") String name,
			@Param("url") String url,
			@Param("createAt") LocalDateTime createAt,
			@Param("updatedAt") LocalDateTime updatedAt);
	
	// input : X
	// output : Bookmark or Null
	// 6.1.2 결과 페이지
	public List<Bookmark> selectBookmarkList();
}
