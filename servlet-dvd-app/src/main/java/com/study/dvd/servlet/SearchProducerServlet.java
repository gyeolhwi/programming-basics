package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dvd.dao.ProducerDao;
import com.study.dvd.entity.Producer;

@WebServlet("/producer/search")
public class SearchProducerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/*
	 * 	1. 요청 URL = /producer/search
	 * 	2. dao.producerDao => searchProdcuerByProducerName()
	 * 	3. entity.Producer
	 * 	4. search_producer.jsp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet 요청들어옴");
		req.getRequestDispatcher("/WEB-INF/views/search_producer.jsp").forward(req, resp);
	}
	
}