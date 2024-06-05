package com.fitness.board.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fitness.board.dao.UserDao;
import com.fitness.board.dto.User;

import jakarta.validation.Valid;


@Controller
public class RegisterController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/register/add")
	public String register(Model model) {
		return "registerForm";
	}
	
	@PostMapping("/register/save")
	public String save(@Valid @ModelAttribute User user, Model m, BindingResult bindingResult) throws Exception {
		
		if(bindingResult.hasErrors()) {
			return "registerForm";
		}
		
		userDao.insertUser(user);
		return "registerSuccess";
	}

}
