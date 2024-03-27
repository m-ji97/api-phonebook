package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	private SqlSession sqlSession;
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		
		sqlSession.insert("phonebook.insert", personVo);
	}

}
