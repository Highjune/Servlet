import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,  HttpServletResponse resp) 
			throws ServletException,  IOException{
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req,  HttpServletResponse resp)
     throws ServletException,  IOException{
		
		req.setCharacterEncoding("utf-8");   //POST방식으로 한글이 넘어올 때
		String name = req.getParameter("username");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("userage"));
		String city = req.getParameter("usercity");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>회원정보</title>");
		out.println("</head>");
		out.println("<body>");
		String str = String.format("%1$tY-%1$tm-%1$td", new Date());
		out.println("<h2>가입한 회원정보</h2>");
		out.println("<ul>");
		out.println("<li>이름 : " + name + "</li>");
		out.println("<li>성별 : " + gender + "</li>");
		out.println("<li>나이 : " + age + "</li>");
		out.println("<li>거주지 : " + city + "</li>");
		out.println("<li>가입일 : " + str + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}




