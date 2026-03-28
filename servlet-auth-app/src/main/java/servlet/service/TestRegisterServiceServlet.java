package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.testDao;
import entity.test;

@WebServlet("/api/test/register")
public class TestRegisterServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		System.out.println(username);
		
		test user = test.builder()
				.userName(username)
				.password(BCrypt.hashpw(password, BCrypt.gensalt()))
				.name(name)
				.email(email)
				.build();
		
		if(testDao.findUserNameByUserId(username) != null) {
			StringBuilder builder = new StringBuilder();
			builder.append("<script>");
			builder.append("alert('해당 ID는 이미 존재합니다');");
			builder.append("history.back();");
			builder.append("</script>");
			resp.setContentType("text/html");
			resp.getWriter().println(builder.toString());
		};
		
		int successCount =  testDao.save(user);
		if(successCount > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("<script>");
			builder.append("alert('회원가입에 성공했습니다! \\n로그인 후 이용하세요');");
			builder.append("location.replace('/ssa/index');");
			builder.append("</script>");
			resp.setContentType("text/html");
			resp.getWriter().println(builder.toString());
		}
		
	}
	
}