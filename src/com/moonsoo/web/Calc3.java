package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = "";
		if(cookies != null) {//��Ű�� ������ ���� ���� ����		
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("expression")) {
					exp = cookie.getValue();
					break;
				}
			}
		}
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");//�ڹٽ�ũ��Ʈ �ڵ带 �������ִ� api
			try {
				exp = String.valueOf(engine.eval(exp));//�ڵ� ����
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator != null && operator.equals("C")) {
			exp = "";
		}
		else if(operator != null && operator.equals("BS")) {
			if(!exp.equals(""))
				exp = exp.substring(0, exp.length()-1);
		}
		else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":dot;			
		}
		
		
		Cookie expCookie = new Cookie("expression", exp);
		if(operator != null && operator.equals("C") || exp.equals("")) {
			expCookie.setMaxAge(0);//��Ű �ٷ� ����
		}
		response.addCookie(expCookie);
		response.sendRedirect("/calcpage");		
	}

}
