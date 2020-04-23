import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//웹은 main이 없다. user가 요청하면 doGet이 발동하는 것임(가만히 기다리고 있다가)
//웹이므로 public
//서블릿은 아래처럼 쓰도록 고정되어 있다.




@WebServlet("/servlet/Hello")
public class HelloServlet extends HttpServlet {  //모든 서블릿의 자식은 무조건 HttpServlet의 자식
	//user한테 보내면 response. user한테 받으면 request

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  //부모(HttpServlet)가 만든 것 그대로. 무조건 파라미터가 2개
			throws ServletException, IOException{
		//브라우저로 보내는 것임
		PrintWriter out = resp.getWriter(); 
		out.println("<font size='7' color='blue'><b>Hello, Servlet</b></font>");
		out.close();
	}
}


//서블릿은 이렇게 모든 코드를 자바 속에 넣는다. cf) html안에 자바를 넣는 것이 jsp
//서버에서 실행하는 자바 프로그램=servlet
//Servlet = Server(was) + Applet(Application + let)
//application은 방명록, 게시판 등등

