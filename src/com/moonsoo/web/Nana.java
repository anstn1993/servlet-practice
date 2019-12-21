package com.moonsoo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter(); 
		String temp = req.getParameter("cnt");
		int cnt = 100;
		if(temp != null && !temp.equals("")) {			
			cnt = Integer.parseInt(temp);
		}
		
		for (int i = 0; i<cnt; i++) {
			pw.println((i+1)+": ¾È³ç, world!!!<br>");
		}
	}
}
