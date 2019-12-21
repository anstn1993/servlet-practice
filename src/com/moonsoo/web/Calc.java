package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String tempX = request.getParameter("x");
		String tempY = request.getParameter("y");
		String operator = request.getParameter("operator");
		
		int x = 0;
		int y = 0;
		PrintWriter pw = response.getWriter();
		if(!tempX.equals("") && !tempY.equals("")) {
			x = Integer.parseInt(tempX);
			y = Integer.parseInt(tempY);
			int result = 0;
			if(operator.equals("����")) {
				result = x+y;
			}
			else {
				result = x-y;
			}
			pw.println("��� ���: "+(result));
			return;
		}
		
		pw.println("��ȿ���� ���� ��");
		response.sendRedirect("/calc.html");//add.html�� �����̷�Ʈ
	}

}
