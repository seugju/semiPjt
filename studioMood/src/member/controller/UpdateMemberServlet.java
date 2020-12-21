package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**s
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		member.setPhone(request.getParameter("phone"));
		member.setBirth(request.getParameter("birth"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("addr"));
		
		int result = new MemberService().updateMember(member);
		
		if(result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "수정되었습니다.");
			request.setAttribute("loc", "/");
			request.setAttribute("member", member);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "수정 실패하였습니다.");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
