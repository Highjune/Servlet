import java.io.IOException;   
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;
import com.example.vo.MemberVO;

@WebServlet("/servlet/List")  //user가 호출하는 것. user는 List클래스를 호출하는 것인줄 알지만 사실은 ListServlet을 호출하는 것임.
public class ListServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws IOException, ServletException{
		
		MemberService service = new MemberServiceImpl();
		List<MemberVO> list = service.selectAll(); //dao에 직접 가지 못하므로 service의 selectAll()이 db에 다녀와서 list를 넘겨준다.
		
		//view, react, angular는 아래처럼 직접 ui를 그리지 않는다. 보내주는 json을 view, react, angular들이 직접 받아서 그림.
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<meta charset='utf-8'>");
		out.println("<h1 style='text-align:center'>회원 명단(" + list.size() + "명)</h1>");
		out.println("<div style='text-align:center'><a href='/0317/register.html'>가입하기</a></div>");
		out.println("<table border='1' style='width:600;margin-left:auto;margin-right:auto'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>번호</th><th>이름</th><th>성별</th><th>나이</th><th>거주지</th><th>등록일</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(int i = 0 ; i < list.size() ; i++) {
			MemberVO member = list.get(i);  //List에 들어갈 때는 add, 뽑을 때는 get, 지울 때는 remove
			int idx = member.getIdx();
			out.println("<tr>");
			out.println("<td>" + idx + "</td>");
			out.println("<td><a href='/0317/servlet/Select?idx=" + idx + "'>" + member.getName() + "</a></td>");
			out.println("<td>" + member.getGender() + "</td>");
			out.println("<td>" + member.getAge() + "</td>");
			out.println("<td>" + member.getCity() + "</td>");
			out.println("<td>" + member.getRegdate() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.close();
	}
}
