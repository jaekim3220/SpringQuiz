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
	// output : boolean t(0이 아닌 수):중복 f(0):중복 아님
	// 6.2.1 북마크 추가 화면
	public boolean isDuplicatedUrl(String url) {
		return bookmarkMapper.isDuplicatedUrl(url);
	}
	
	
	// input : url
	// output : Bookmark 행, boolean으로 return
	// output : boolean t(0이 아닌 수):중복 f(0):중복 아님
	// 6-2 URL 중복확인 - AJAX 요청(SELECT)
	// boolean이 아닌 List 타입으로 메서드를 생성하는 것도 방법
	public boolean isDuplicateUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkByUrl(url);
		
		// 비어있으면 중복이 아니므로, empty true => false
		return bookmarkList.isEmpty() == false;
		
	}
	
	// input : int id
	// output : 성공한 행의 수 int
	// 6-2 URL 중복확인 - AJAX 요청(DELETE)
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
}
