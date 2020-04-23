import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//xml안 쓰면 다 @(annotation)을 쓴다. spring에서도 마찬가지.
//@WebServlet("/servlet/Test")   
//annotation을 쓰면 아래와 같이 url패턴을 많이 쓸 수도 있다.
@WebServlet(name="HangulDemoServlet", urlPatterns={"/servlet/Xxx", "/servlet/Yyy"})  
public class HangulServlet extends HttpServlet { 
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//resp - user에게 보내는 것.(response)
		res.setContentType("text/html;charset=utf-8");  //한글위한 조건1(content type)
		
		//user와 was사이에 터널링이 생기는 것임(터널로 데이터 보냄)
		PrintWriter out = res.getWriter(); //자바 web에서는 무조건 다 printwriter를 사용한다. (스탠다드edition에서는 printstream), 접미사 writer이므로 한글이나 일본어처럼 2byte 처리가능(char형으로)
		out.println("<meta charset='utf-8'>"); //한글 위한 조건2. 조건3은 이 문서의 저장인코딩 utf-8,  웹으로 저장할 때는 모든 문서는 무조건 utf-8로 저장(제일 아래 필기 참조)
		//cf) 자바 standard로 저장할 때는 ANSI(ms-949)로 저장.
		
		out.println("<font size='7' color='blue'><b>Hello, 서블릿</b></font>"); //브라우저가 이 태그를 받아서 그리는 것임
	}
}

//이클립스에서 인코딩하는 법 3가지
//1. 본 문서/ edit -set encoding
//2. 해당 프로젝트만 / 해당 프로젝트 우클릭 - properties
//3. 전체 프로젝트 / windows - preferences - general - workspace
//이렇게 해도 되고, windows - preferences - web - css/html/jsp 를 각각 다 utf-8로 바꾸기
