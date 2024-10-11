package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class RealtorBO {

	@Autowired
	private RealtorMapper realtorMapper;
	
	// input : realtor 데이터
	// output : int or void
	public void addRealtor(Realtor realtor) {
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		realtorMapper.insertRealtor(realtor);
	}

	
	// input : realtor의 id 데이터
	// output : realtor 데이터
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
}
