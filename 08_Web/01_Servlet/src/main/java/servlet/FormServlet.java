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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");

		gender = gender.equals("M") ? "남자" : "여자";

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> 아이디 : " + userId + "</h1>");
		out.println("<h1> 비밀번호 : " + password + "</h1>");
		out.println("<h1> 성별 : " + gender + "</h1>");
		// out.println("<h1> 좋아하는 메뉴 : " + Arrays.toString(menu) + "</h1>");
		// out.println("<h1> 좋아하는 메뉴 : " + String.join(", ", menu) + "</h1>");

		if (menu != null) {
			out.println("<h1> 좋아하는 메뉴</h1>");
			out.println("<ul>");
			for (String m : menu) {
				out.println("<li>" + m + "</li>");
			}
			out.println("</ul>");
		}

		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
