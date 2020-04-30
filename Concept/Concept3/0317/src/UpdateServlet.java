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

@WebServlet("/servlet/Update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException{
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.select(idx);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//register.html것 그대로 복사해서와서 out.println붙임.
		//그리고 원래 아래처럼 <!DOCTYPE html>부터 다 써야되는데 없는 servlet들은 그냥 표현만 하기 위해서 임의로 생략한 것이다.
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">  ");  
		out.println("    <title>회원정보 수정</title>");
		out.println("<link rel=\"stylesheet\" href=\"../css/style.css\">");
		out.println("    <script src=\"../js/jquery-3.4.1.js\"></script>");  //jquery
		out.println("    <script>");
		out.println("        $(function(){");    //jqeury 이벤트
		out.println("            $(\"button\").bind(\"click\", function(){");
		out.println("                $('form').submit();");
		out.println("            });");
		out.println("        });");
		out.println("    </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <h1>회원정보 수정</h1>");
		out.println("    <form action=\"/0317/servlet/UpdateAction\" method=\"POST\">");  //submit하면 servlet/UpdateAction이 받음. 사실 servlet/UpdateActionServlet 이라고 해도 되는데, user에게 클래스를 공개하지 않으려고.
		//user는 UpdateAction인줄 알지만 실제 클래스는 UpdateActionservlet		
		out.println("<input type='hidden' name='idx' value='" + member.getIdx() + "'>");  //hidden
		//위에서 idx를 가져온 상태인데, 수정해서 넘길 때(form안의 것만 전송됨)는 form안에 index가 없기 때문에 서버는 idx를 모른다. 그래서 번호를 숨긴채로 넘겨줘야 한다.
		//즉 form안에 idx는 넘겨야 하고 user에게 공개하고 싶지 않으면 hidden(소스보기 하면 보인다)	
		out.println("        <ul>");
		out.println("            <li>Name : <input type=\"text\" name=\"name\" value='" + member.getName() + "' required readonly></li>"); //readonly 줘서 수정하면 안되는 부분(이름) 고정
		out.println("            <li>Gender : ");
		String gender = member.getGender();
		if(gender.trim().equals("male")) {  
			out.print("                <input type=\"radio\" name=\"gender\" value=\"male\" ");
			out.println("checked>남성&nbsp;&nbsp;");
			out.println("                <input type=\"radio\" name=\"gender\" value=\"female\">여성");
		}else if(gender.trim().equals("female")) {
			out.println("                <input type=\"radio\" name=\"gender\" value=\"male\">남성&nbsp;&nbsp; ");
			out.print("                <input type=\"radio\" name=\"gender\" value=\"female\" ");
			out.println("checked>여성");
		} 
		out.println("         </li>");
		out.println("         <li>Age : <input type=\"number\" name=\"age\" min=\"20\" max=\"65\" value='" + member.getAge() + "' required></li>");
		out.println("          <li>City : ");
		String city = member.getCity();
		out.println("              <select name=\"city\">");
		out.println("                  <option>--선택--</option>");
		if(city.trim().equals("서울"))
			   out.println("                  <option value=\"서울\" selected>서울</option>");
		else out.println("                  <option value=\"서울\">서울</option>");
		if(city.trim().equals("부산"))
			   out.println("                  <option value=\"부산\" selected>부산</option>");
		else out.println("                  <option value=\"부산\">부산</option>");
		if(city.trim().equals("대전"))
			   out.println("                 <option value=\"대전\" selected>대전</option>");
		else out.println("                 <option value=\"대전\">대전</option>");
		if(city.trim().equals("인천"))
			   out.println("                  <option value=\"인천\" selected>인천</option>");
		else out.println("                  <option value=\"인천\">인천</option>");
		if(city.trim().equals("제주"))
			   out.println("                  <option value=\"제주\" selected>제주</option>");
		else out.println("                  <option value=\"제주\">제주</option>");
		out.println("         </select>");
		out.println("      </li>");
		out.println("     <li><button type=\"button\">수정하기</button></li>"); //form안에 있는 button은 submit이다.
		out.println("     <li><button type=\"button\" onclick='history.back();'>취소하기</button></li>");
		out.println("  </ul>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
