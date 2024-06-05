package com.fitness.board.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fitness.board.dao.UserDao;
import com.fitness.board.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpServletRequest request) throws Exception {
		String loginId = user.getUser_id();
		String pwd = user.getPwd();
		
		if (!loginCheck(loginId, pwd)) {
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            return "redirect:/login?msg=" + msg;
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginId", loginId);

        return "redirect:/";
	}
	
	private boolean loginCheck(String user_id, String pwd) {
        User user = null;

        try {
            user = userDao.selectUser(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return user != null && user.getPwd().equals(pwd);
    }

}
