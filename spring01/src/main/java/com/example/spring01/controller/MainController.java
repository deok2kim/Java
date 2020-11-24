package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.PointDTO;

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
	
	// requestParam = 개별변수로 전달
	// modelattribute = 모델클래스로 한꺼번에 전달
	@RequestMapping("gugu_result.do")
	public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
		String result = "";
		for (int i = 1; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu_result";
	}
	
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKorean() + dto.getEnglish() + dto.getMath());
		String average = String.format("%.2f", dto.getTotal()/3.0);
		dto.setAverage(Double.parseDouble(average));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	
	// 리다이렉트
	@RequestMapping("move.do")
	public String move() {
		return "redirect:/result.do?name=kim&age=20";
	}
	
	@RequestMapping("result.do")
	public String result(Model model,
			@RequestParam(defaultValue = "noname") String name,
			@RequestParam(defaultValue = "10") int age) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		 
		return "test/result";
	}
}
