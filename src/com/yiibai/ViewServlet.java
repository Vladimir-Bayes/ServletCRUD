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
		out.println("<a href='index.html'>添加新员工</a>");  
		out.println("<h1>员工列表</h1>");  

		List<Emp> list=EmpDao.getAllEmployees();  

		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>编号</th><th>姓名</th><th>年龄</th><th>学历</th><th>薪水</th><th>地址</th><th>操作</th></tr>");  
		for(Emp e:list){  
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td><td>"+e.getEducation()+"</td><td>"+e.getSalary()+"</td><td>"+e.getAddress()+"</td><td><a href='EditServlet?id="+e.getId()+"'>编辑</a> | <a href='DeleteServlet?id="+e.getId()+"' onClick=\"return confirm('确定要删除吗？')\">删除</a></td></tr>");  
		}  
		out.print("</table>");  
		out.close();  
	}

}
