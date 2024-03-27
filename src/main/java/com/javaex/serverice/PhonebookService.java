package com.javaex.serverice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	private String exeWrite(PersonVo personVo) {
	System.out.println("PhonebookService.exeWrite()");
	
	phonebookDao.personInsert(personVo);
	return "";
	}

}
