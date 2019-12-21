package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] nums_ = request.getParameterValues("num");
		
		int result = 0;
		PrintWriter pw = response.getWriter();
		
		for(int i = 0; i < nums_.length; i++) {
			if(nums_[i].equals("")) {
				response.sendRedirect("/add2.html");//add2.html로 리다이렉트
				return;
			}
			result += Integer.parseInt(nums_[i]);
		}
		
		pw.println("계산 결과: " + result);
		
	}

}
