package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext application = request.getServletContext();//application저장소 객체
		HttpSession session = request.getSession();//세션 객체
		
		Cookie[] cookies = request.getCookies();
		
		
		String v_ = request.getParameter("v");
		String operator = request.getParameter("operator");
		
		if(session.isNew()) {
			System.out.println("new session");
		}
		else {
			System.out.println("old session");
		}
		
		System.out.println("session creation time: " + session.getCreationTime());
		System.out.println("last session access time: " + session.getLastAccessedTime());
		
		
		int v = 0;
		if(!v_.equals("") ) {			
			v = Integer.parseInt(v_);
		} 
			
		
		//계산
		if(operator.equals("=")) {
//			int x = (Integer)application.getAttribute("value");
			
//			int x = (Integer)session.getAttribute("value");
			
			int x = 0;
			int y = v;
//			String op = (String)application.getAttribute("operator");

//			String op = (String)session.getAttribute("operator");
			
			String op = null;
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("value")) {
					x = Integer.parseInt(cookie.getValue());
					break;
				}
			}
			
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("operator")) {
					op = cookie.getValue();
					break;
				}
			}
			
			int result = 0;
			if(op.equals("+")) {
				result = x+y;
			}
			else {
				result = x-y;
			}
			response.getWriter().println("계산 결과: " + result);				
		}
		//값 저장
		else {
//			application.setAttribute("value", v);
//			application.setAttribute("operator", operator);
			
//			session.setAttribute("value", v);
//			session.setAttribute("operator", operator);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60*24);//one day
			Cookie operatorCookie = new Cookie("operator", String.valueOf(operator));
			operatorCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(operatorCookie);
			
			response.sendRedirect("/calc2.html");//calc2.html로 리다이렉트
			return;
		}
		
		
	}

}
