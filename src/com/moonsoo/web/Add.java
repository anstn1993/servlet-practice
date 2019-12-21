package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String tempX = request.getParameter("x");
		String tempY = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		PrintWriter pw = response.getWriter();
		if(tempX != null && tempY != null && !tempX.equals("") && !tempY.equals("")) {
			x = Integer.parseInt(tempX);
			y = Integer.parseInt(tempY);
			pw.println("계산 결과: "+(x+y));
			return;
		}
		
		pw.println("유효하지 않은 값");
		response.sendRedirect("/add.html");//add.html로 리다이렉트
	}

}
