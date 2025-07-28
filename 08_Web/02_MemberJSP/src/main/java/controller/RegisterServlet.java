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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. (있으면) 폼 값 받아온다.
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));

		boolean check = true;

		// 2. DAO 호출 - DB 접근 필요시
		MemberDAO dao = new MemberDAO();

		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			check = false;
		}

		// 3. 바인딩 :  결과 페이지에 서버에서 받은 값 보내야 할 때
		// 바인딩은 여러개해도 상관없다고 함
		//request.setAttribute("name", name);
		request.setAttribute("check", check);
		
		// 4. 네비게이션 : 결과 페이지 지정
		// 회원가입 성공할 때랑 실패할 때 페이지를 구분하는 것
		// check가 true인 경우는 회원가입 성공 페이지로 이동
		//if (check) {
			//response.sendRedirect("result.jsp"); 
			// 만약 결과 페이지로 서버에서 받은 값 보여주려면 response는 사용이 불가함
			// RequestDispatcher forward  방식으로 보내야함
		
		    // 결과 페이지는 하나로
			request.getRequestDispatcher("result.jsp").forward(request, response);
			// 또 다시 request할 일이 있다는 뜻
		
			//} else {
			//response.sendRedirect("fail.jsp");
			// 응답하고 끝
		//}		
		// false인 경우는 실패 페이지로 이동 -> fail.jsp

	}

}
