package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;


/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service
public class StoreBo {
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private StoreMapper storeMapper;

	// input : None 컨트롤러한테 받는다
	// output : 컨트롤러한테 제공. List<Store>
	public List<Store> getStoreList() {
		List<Store> storeList = storeMapper.selectStoreList();// DB에서 추출한 데이터
		return storeList; // 컨트롤러한테 return
	}
}
