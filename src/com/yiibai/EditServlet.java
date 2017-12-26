package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>更新员工信息</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Emp e = EmpDao.getEmployeeById(id);

		String education = e.getEducation();

		out.print("<form action='EditServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>名字:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		out.print("<tr><td>年龄:</td><td><input type='text' name='age' value='" + e.getAge()+ "'/></td></tr>");
		out.print("<tr><td>地址:</td><td><input type='text' name='address' value='" + e.getAddress() + "'/></td></tr>");
		out.print("<tr><td>学历:</td><td>");
		out.print("<select name='education' style='width:150px'>");
		if(education == "专科") {
			out.print("<option value='专科' selected='selected'>专科</option>");
		}else {
			out.print("<option value='专科'>专科</option>");
		}

		if(education == "本科") {
			out.print("<option value='本科' selected='selected'>本科</option>");
		}else {
			out.print("<option value='本科'>本科</option>");
		}

		if(education == "研究生") {
			out.print("<option value='研究生' selected='selected'>研究生</option>");
		}else {
			out.print("<option value='研究生'>研究生</option>");
		}
		if(education == "博士") {
			out.print("<option value='博士' selected='selected'>博士</option>");
		}else {
			out.print("<option value='博士'>博士</option>");
		}

		if(education == "其它") {
			out.print("<option value='其它' selected='selected'>其它</option>");
		}else {
			out.print("<option value='其它'>其它</option>");
		}
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>薪水:</td><td><input type='text' name='salary' value='" + e.getSalary() + "'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='编辑&保存'/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String education = request.getParameter("education");
		String salary = request.getParameter("salary");

		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setAddress(address);
		e.setAge(Integer.parseInt(age));
		e.setSalary(Float.parseFloat(salary));
		e.setEducation(education);

		int status = EmpDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("对不起更新信息失败！");
		}
		out.close();
	}

}
