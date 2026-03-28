package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 띄워주는 곳 
@WebServlet("/search")
public class SearchDvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// jsp 파일 불려오려면 request dispatch 사용
		req.getRequestDispatcher("/WEB-INF/views/search_dvd.jsp").forward(req, resp); // forward로 req,resp 인수 보내줌
	}
}
