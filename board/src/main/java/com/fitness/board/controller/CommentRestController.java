package com.fitness.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentRestController {
	@GetMapping("/test2")
	public String test2() {
		return "test2";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
