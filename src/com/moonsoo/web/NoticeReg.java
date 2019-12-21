package com.moonsoo.web;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8");
		
//		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("제목: " + title + "<br>");
		pw.println("내용: " + content + "<br>");
		
	}

}
