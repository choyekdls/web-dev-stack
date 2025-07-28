package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import dao.MemberDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {

			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			Member member = dao.searchMember(id);
			System.out.println(member);
			request.setAttribute("member", member);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("search.jsp").forward(request, response);

	}
}
