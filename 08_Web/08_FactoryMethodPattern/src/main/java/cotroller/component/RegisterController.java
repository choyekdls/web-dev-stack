package cotroller.component;

import java.sql.SQLException;

import cotroller.Controller;
import cotroller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));

		MemberDAO dao = new MemberDAO();
	    dao.register(new Member(id, name, pwd, age));
       
	
		return new ModelAndView("index.jsp", true);
	}

}
