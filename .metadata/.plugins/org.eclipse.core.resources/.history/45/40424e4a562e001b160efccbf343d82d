package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	
	@RequestMapping("gugu_result.do")
	public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
		String result = "";
		for (int i = 1; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu_result";
	}
}
