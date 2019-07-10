package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.UserService;

/**
 * Servlet implementation class checkServlet
 */
@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  name=request.getParameter("name");
		if(name.length()==0) {
			PrintWriter out=response.getWriter();
			out.write("yes");
		}
		UserService  userService=new UserService();
		boolean f=userService.checkUser(name);
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		
		 if(f) {
			
			 out.write("yes");
		 }else {
			 out.write("no"); 
		 }
		   
		    out.flush();
		    out.close();  
	}

		
	}
