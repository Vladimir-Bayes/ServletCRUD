package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();  
		out.println("<a href='index.html'>�����Ա��</a>");  
		out.println("<h1>Ա���б�</h1>");  

		List<Emp> list=EmpDao.getAllEmployees();  

		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>���</th><th>����</th><th>����</th><th>ѧ��</th><th>нˮ</th><th>��ַ</th><th>����</th></tr>");  
		for(Emp e:list){  
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td><td>"+e.getEducation()+"</td><td>"+e.getSalary()+"</td><td>"+e.getAddress()+"</td><td><a href='EditServlet?id="+e.getId()+"'>�༭</a> | <a href='DeleteServlet?id="+e.getId()+"' onClick=\"return confirm('ȷ��Ҫɾ����')\">ɾ��</a></td></tr>");  
		}  
		out.print("</table>");  
		out.close();  
	}

}
