import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���� main�� ����. user�� ��û�ϸ� doGet�� �ߵ��ϴ� ����(������ ��ٸ��� �ִٰ�)
//���̹Ƿ� public
//������ �Ʒ�ó�� ������ �����Ǿ� �ִ�.




@WebServlet("/servlet/Hello")
public class HelloServlet extends HttpServlet {  //��� ������ �ڽ��� ������ HttpServlet�� �ڽ�
	//user���� ������ response. user���� ������ request

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  //�θ�(HttpServlet)�� ���� �� �״��. ������ �Ķ���Ͱ� 2��
			throws ServletException, IOException{
		//�������� ������ ����
		PrintWriter out = resp.getWriter(); 
		out.println("<font size='7' color='blue'><b>Hello, Servlet</b></font>");
		out.close();
	}
}


//������ �̷��� ��� �ڵ带 �ڹ� �ӿ� �ִ´�. cf) html�ȿ� �ڹٸ� �ִ� ���� jsp
//�������� �����ϴ� �ڹ� ���α׷�=servlet
//Servlet = Server(was) + Applet(Application + let)
//application�� ����, �Խ��� ���

