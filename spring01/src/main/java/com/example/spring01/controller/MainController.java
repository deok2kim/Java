package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 컨트롤러 어노테이션( 얘는 컨트롤러다 라고 지정해주는 것)
public class MainController {
	
	// http://localhost:8080/spring01
	@RequestMapping("/")  // URL 매핑
	public String main(Model model) {
		model.addAttribute("name", "김덕기");
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");  // 앞이 변수명, 뒤가 값
		return "main";  // main.jsp
		// "/WEB-INF/views/main.jsp 라는 뜻 - 뷰리졸버에 이미 되어있음
	}
}
