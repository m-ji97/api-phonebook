package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.Service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;

import ch.qos.logback.core.model.Model;

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
	@PostMapping("/write")
	public JsonResult write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		phonebookService.exeWrite(personVo);
		
		return "redirect:/list";
	}
	//리스트
	@GetMapping("/list")
	public JsonResult list(Model model) {
		System.out.println("PhonebookController.list()");
		
		JsonResult pList = phonebookService.exeList();
		model.addAttribute("pList", personList);
		
		return "list";
	}
	//삭제
	@DeleteMapping("/delete/{id}")
	public JsonResult delete(@PathVariable(value="id") int no) {
		System.out.println("PhonebookController.delete()");
		PersonVo personVo = phonebookService.exeDelete(no);
		return "redirect:/list";
		
	}
	//수정폼
	@GetMapping("modifyform/{id}")
	public JsonResult modifyform(@PathVariable(value="id") int no) {
		System.out.println("PhonebookController.modifyform()");
		PersonVo personVo = phonebookService.exeGetUpdate(no);
		return JsonResult.success(personVo);
	}
	
	//수정
	@PostMapping("modify")
	public JsonResult delete(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.delete()");
		int count = phonebookService.exeUpdate(personVo);
		if(count >=1) {
			System.out.println("수정되었습니다");
			return JsonResult.success(personVo);
		}else {
			return JsonResult.fail("수정 안되었습니다");
		}
	}
	//삭제
	@DeleteMapping("/delete/{id}")
	public JsonResult delete() {
		System.out.println("PhonebookController.delete()");
		phonebookService.exeDelete(no);
		return JsonResult.success(no);
	}

}
