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
		
		//ListServlet(회원전체명단list)에서 특정회원 클릭하면 그 회원의 idx(pk)가 이 서블릿에게 idx를 준다.
		//받은idx -> service에게 -> service는 dao에 다녀와서 member를 던져준다.
		//그러면 그 받은 member에 대한 정보를 뿌려줌.
	
		int idx = Integer.parseInt(req.getParameter("idx"));   // sevlet/Select?idx=5
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.select(idx); 
		
		//한글을 위한 3가지 조건(이 문서의 encoding - utf-8)
		resp.setContentType("text/html;charset=utf-8"); //한글을 위한 2번째 조건
		PrintWriter out = resp.getWriter(); //user의 webrowser와 webServer사이의 터널(세션) 로 데이터를 주고 받는다.
		out.println("<meta charset='utf-8'>");//한글을 위한 3번째 조건
		out.println("<h1>" + member.getName() + "'s Information</h1>");
		out.println("<ul>");
		out.println("<li>성별 : " + member.getGender() + "</li>");
		out.println("<li>나이 : " + member.getAge() + "</li>");
		out.println("<li>거주지 : " + member.getCity() + "</li>");
		out.println("<li>등록일 : " + member.getRegdate() + "</li>");
		out.println("</ul>");
		out.println("<input type='button' value='목록으로' onclick='history.back();'>"); //이벤트 dom레벨1으로 inline으로. (원래는 dom레벨2로 해야된다). 지금은 html코드 최소화하기 위해.
		
		//<input type="button" value="수정하기" onclick="location.href='/0317/servlet/Update?idx=member.getIdx()'">임
		out.println("<input type='button' value='수정하기' ");
		out.println("onclick='location.href=\"/0317/servlet/Update?idx=" + member.getIdx() + "\"'>"); //location.href로 redirect

		out.print("<input type='button' value='삭제하기' ");
		out.println("onclick='location.href=\"/0317/servlet/Delete?idx=" + member.getIdx() + "\"'>");
		
		out.close();
	}
}
