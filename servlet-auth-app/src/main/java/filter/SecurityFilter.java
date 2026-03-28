package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;

//@WebFilter({"/mypage","/mypage/password"})
@WebFilter(filterName = "securityFilter")
public class SecurityFilter extends HttpFilter implements Filter {
//	private static final long serialVersionUID = 1L;
	
	// 로그인이 필요한 특정페이지 접근에대해서 로그인유무확인 메소드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 다운캐스팅 req.setAttribute 할 때 하던 것..?
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		User user = (User)session.getAttribute("authentication");
		if(user == null) {
			StringBuilder responseBody = new StringBuilder();
			responseBody.append("<script>");
			responseBody.append("alert('잘못된 접근입니다.\\n 로그인 후 이용바랍니다');");
			responseBody.append("location.href='/ssa/login';");
			responseBody.append("</script>");
			response.setContentType("text/html");
			response.getWriter().println(responseBody.toString());
			return;
		}
		
		chain.doFilter(request, response);
	}
}