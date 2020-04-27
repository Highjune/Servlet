import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;
import com.example.vo.MemberVO;

@WebServlet("/servlet/Select")
public class SelectServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req,  HttpServletResponse resp)
     throws ServletException, IOException{
		
		int idx = Integer.parseInt(req.getParameter("idx"));   // sevlet/Select?idx=5
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.select(idx);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<meta charset='utf-8'>");
		out.println("<h1>" + member.getName() + "'s Information</h1>");
		out.println("<ul>");
		out.println("<li>성별 : " + member.getGender() + "</li>");
		out.println("<li>나이 : " + member.getAge() + "</li>");
		out.println("<li>거주지 : " + member.getCity() + "</li>");
		out.println("<li>등록일 : " + member.getRegdate() + "</li>");
		out.println("</ul>");
		out.println("<input type='button' value='목록으로' onclick='history.back();'>");
		out.println("<input type='button' value='수정하기' ");
		out.println("onclick='location.href=\"/0317/servlet/Update?idx=" + member.getIdx() + "\"'>");
		out.print("<input type='button' value='삭제하기' ");
		out.println("onclick='location.href=\"/0317/servlet/Delete?idx=" + member.getIdx() + "\"'>");
		out.close();
	}
}
