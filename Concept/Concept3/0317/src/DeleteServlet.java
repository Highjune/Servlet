import java.io.IOException;   
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;

@WebServlet("/servlet/Delete")
public class DeleteServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException,  IOException{
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		MemberService service = new MemberServiceImpl();
		int row = service.delete(idx);
		
		PrintWriter out = resp.getWriter();
		if(row == 1) {
			out.println("<script>");
			out.println(" location.href = '/0317/servlet/List'; ");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println(" alert('회원 삭제 실패했습니다. 다시 시도해 주세요.'); ");
			out.println(" history.back();  ");
			out.println("</script>");
		}
		out.close();
	}
}
