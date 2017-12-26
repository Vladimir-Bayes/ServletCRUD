package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        //System.out.println("age is :"+age);
        String education = request.getParameter("education");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");

        Emp e = new Emp();
        e.setName(name);
        e.setAge(Integer.parseInt(age));
        e.setAddress(address);
        e.setEducation(education);
        e.setSalary(Float.parseFloat(salary));

        int status = EmpDao.save(e);
        if (status > 0) {
            out.print("<p>保存员工信息记录成功！</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("对不起，保存失败！");
        }

        out.close();
	}

}
