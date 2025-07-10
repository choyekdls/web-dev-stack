package cotroller.component;

import java.util.List;

import cotroller.Controller;
import cotroller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.allMemer();
		request.setAttribute("list", list);
		return new ModelAndView("/views/allMember.jsp");
	}

}
