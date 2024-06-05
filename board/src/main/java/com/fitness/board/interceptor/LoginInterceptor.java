package com.fitness.board.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String loginId = (String) session.getAttribute("loginId");
            request.setAttribute("loginId", loginId);
            request.setAttribute("loginOutLink", loginId != null && !loginId.isEmpty() ? "/logout" : "/login");
            request.setAttribute("loginOut", loginId != null && !loginId.isEmpty() ? "ID=" + loginId : "Login");
        } else {
            request.setAttribute("loginId", "");
            request.setAttribute("loginOutLink", "/login");
            request.setAttribute("loginOut", "Login");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("loginId", request.getAttribute("loginId"));
            modelAndView.addObject("loginOutLink", request.getAttribute("loginOutLink"));
            modelAndView.addObject("loginOut", request.getAttribute("loginOut"));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
