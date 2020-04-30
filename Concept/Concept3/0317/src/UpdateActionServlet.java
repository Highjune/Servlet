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

@WebServlet("/servlet/UpdateAction")
public class UpdateActionServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) //updateservlet에서 post로 넘기니까 post로 받음.
     throws ServletException, IOException{
		//user가 못 보는 페이지. update가 성공해서 1이 넘어오면 넘어오자마자 바로 0317/servlet/List로 넘어감		
		
		req.setCharacterEncoding("utf-8");  //POST 방식으로 한글 처리하고자 할 때 해줘야 되는 것. post로 넘기면 한글 다 깨진다.
		int idx = Integer.parseInt(req.getParameter("idx"));  //hidden으로 넘어온 것
		String name = req.getParameter("name"); //readonly로 넘어온 것.
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String city = req.getParameter("city");
		
		MemberVO member = new MemberVO();
		member.setIdx(idx);
		member.setName(name); 
		member.setAge(age);
		member.setGender(gender);
		member.setCity(city);
		
		MemberService service = new MemberServiceImpl();
		int row = service.update(member);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<meta charset='utf-8'>");
		if(row == 1) {
			out.println("<script>");
			out.println(" location.href='/0317/servlet/List'; ");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원정보 수정에 실패했습니다.'); ");
			out.println("history.back(); ");
			out.println("</script>");
		}
		out.close();
	}
}



