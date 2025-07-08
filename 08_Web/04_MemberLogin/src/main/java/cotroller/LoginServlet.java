package cotroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		request.setAttribute("member", member);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", member);
		
		response.sendRedirect("index.jsp");
	}

}
