package servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import dao.testDao;
import entity.test;

@WebServlet("/api/test/login")
public class testLoginServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// id?
		StringBuilder builder = new StringBuilder();
		if(testDao.findUserNameByUserId(username) == null) {
			builder.append("<script>");
			builder.append("alert('로그인정보 불일치');");
			builder.append("history.back()");
			builder.append("</script>");
			resp.setContentType("text/html");
			resp.getWriter().println(builder.toString());
			return;
		}
		test te = testDao.findUserNameByUserId(username);
		if(!BCrypt.checkpw(password, te.getPassword())) {
			builder.append("<script>");
			builder.append("alert('로그인정보 불일치');");
			builder.append("history.back()");
			builder.append("</script>");
			resp.setContentType("text/html");
			resp.getWriter().println(builder.toString());
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("authentication",te);
		resp.sendRedirect("/ssa/index");
		
	}	
}