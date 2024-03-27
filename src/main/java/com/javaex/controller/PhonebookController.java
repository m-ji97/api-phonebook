package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.serverice.PhonebookService;
import com.javaex.vo.PersonVo;

@RestController
public class PhonebookController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	//등록폼
	@GetMapping("/writeform")
	public String writeform() {
		System.out.println("PhonebookController.writeform()");
		
		return "writeform";
	}
	//등록
	@GetMapping("/write")
	public JsonResult write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		phonebookService.exeWrite(personVo);
		
		return "redirect:/list";
	}
	//리스트
	@PostMapping("/list")
	public JsonResult list(Model model) {
		System.out.println("PhonebookController.list()");
		
		JsonResult pList = phonebookService.exeList();
		model.addAttribute("pList", personList);
		
		return "list";
	}
	

}
