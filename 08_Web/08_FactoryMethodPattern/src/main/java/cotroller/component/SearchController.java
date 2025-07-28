package cotroller.component;

import cotroller.Controller;
import cotroller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		Member member = dao.searchMember(id);
		request.setAttribute("member", member);

		return new ModelAndView("/views/result.jsp");
	}

}
