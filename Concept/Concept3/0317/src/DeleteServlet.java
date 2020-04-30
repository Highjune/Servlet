import java.io.IOException;   
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;

@WebServlet("/servlet/Delete")  //@WebServlet이 편하긴 한데 spring에서는 쓰지 않는다.
public class DeleteServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)  //url로 번호가 넘어오니까 get방식
     throws ServletException,  IOException{
		
		int idx = Integer.parseInt(req.getParameter("idx")); //변수이름이 idx임 즉, req.getParameter("idx")의 파라미터 "idx"는 idx=5에서 String 5를 말하는 것임. 
		MemberService service = new MemberServiceImpl();
		int row = service.delete(idx);
		
		PrintWriter out = resp.getWriter();
		if(row == 1) { //삭제가 성공했으면
			out.println("<script>"); //javascript의 redirect
			out.println(" location.href = '/0317/servlet/List'; "); //삭제했으면 목록페이지로 넘어감.
			out.println("</script>");
		}else { //삭제가 실패했으면
			out.println("<script>");
			out.println(" alert('회원 삭제 실패했습니다. 다시 시도해 주세요.'); "); 
			out.println(" history.back();  "); //삭제했으면 이전으로(개인 상세 페이지)
			out.println("</script>");
		}
		out.close();
	}
}
