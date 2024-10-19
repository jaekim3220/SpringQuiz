package com.quiz.lesson06.bo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	
	// input : 파라미터 2개
	// output : int or void
	// 6.1.2 입력 페이지
	public void addBookmark(
			String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input : X
	// output : Bookmark or Null
	// 6.1.2 결과 페이지
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	
	// input : url
	// output : boolean t:중복 f:중복 아님
	// 6.2.1 북마크 추가 화면
	public boolean isDuplicatedUrl(String url) {
		return bookmarkMapper.isDuplicatedUrl(url);
	}
}
