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
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">  ");  
		out.println("    <title>회원정보 수정</title>");
		out.println("<link rel=\"stylesheet\" href=\"../css/style.css\">");
		out.println("    <script src=\"../js/jquery-3.4.1.js\"></script>");
		out.println("    <script>");
		out.println("        $(function(){");
		out.println("            $(\"button\").bind(\"click\", function(){");
		out.println("                $('form').submit();");
		out.println("            });");
		out.println("        });");
		out.println("    </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <h1>회원정보 수정</h1>");
		out.println("    <form action=\"/0317/servlet/UpdateAction\" method=\"POST\">");
		out.println("<input type='hidden' name='idx' value='" + member.getIdx() + "'>");
		out.println("        <ul>");
		out.println("            <li>Name : <input type=\"text\" name=\"name\" value='" + member.getName() + "' required readonly></li>");
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
		out.println("     <li><button type=\"button\">수정하기</button></li>");
		out.println("     <li><button type=\"button\" onclick='history.back();'>취소하기</button></li>");
		out.println("  </ul>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
