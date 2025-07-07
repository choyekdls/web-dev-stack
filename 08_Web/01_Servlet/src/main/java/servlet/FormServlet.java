package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
        String userId = request.getParameter("userId");
        String password = request.getParameter("userPwd");
        String gender = request.getParameter("gender");
        String[] menu = request.getParameterValues("menu");
        
        PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> 아이디 : " + userId + "</h1>");
		out.println("<h1> 비밀번호 : " + password + "</h1>");
		out.println("<h1> 성별 : " + gender + "</h1>");
		out.println("<h1> 좋아하는 메뉴 : " + Arrays.toString(menu) + "</h1>");
		out.println("</body></html>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
