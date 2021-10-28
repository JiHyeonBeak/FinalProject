package com.spring.udong.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("member");
			if(obj == null) {
			response.sendRedirect("/udong/login");
			return false; //false로 설정해야 컨트롤러의 요청url로 이동하지 않음
			}
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
