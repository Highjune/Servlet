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

@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,  HttpServletResponse resp)
     throws ServletException,  IOException{
		
		req.setCharacterEncoding("utf-8");   //POST방식으로 한글이 넘어올 때
		
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String city = req.getParameter("city");
		MemberVO member = new MemberVO(name, gender ,age, city);
		
		MemberService service = new MemberServiceImpl();
		int row = service.create(member);
			
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<meta charset='utf-8'>");
		if(row == 1) {  //insert 성공했다면
//			out.println("<p style='color:blue;font-size:3em'>Insert Success</p>");
			out.println("<script>");
			out.println("   location.href = \"/0317/servlet/List\";");
			out.println("</script>");
		}else {  //실패했다면
//			out.println("<p style='color:red;font-size:3em'>Insert Failure</p>");
			out.println("<script>");
			out.println("alert('회원 가입 실패'); ");
			out.println("history.back(); ");
			out.println("</script>");
		}
		out.close();
	}
}




