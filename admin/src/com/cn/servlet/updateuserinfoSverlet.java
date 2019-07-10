package com.cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.UserService;
import com.cn.vo.User2;

/**
 * Servlet implementation class updateuserinfoSverlet
 */
@WebServlet("/updateuserinfoSverlet")
public class updateuserinfoSverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuserinfoSverlet() {
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
		request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  String id=request.getParameter("id");
		  String userName=request.getParameter("name"); 
		  String password=request.getParameter("pass");
			String email=request.getParameter("email"); 
			String rname=request.getParameter("rname"); 
			String sex=request.getParameter("sex"); 
			String phone=request.getParameter("phone"); 
			String []hobb=request.getParameterValues("hobb"); 
			System.out.print(hobb.toString());
			 String hobbies="";
				for(int i=0;i<hobb.length;i++){
					hobbies= hobbies+hobb[i]+",";
					
				} 
			String introduce=request.getParameter("introduce"); 
			User2  user=new User2();
			user.setid(Integer.parseInt(id));
			user.setname(userName);
			user.setpass(password);
			user.setEmail(email);
			user.setRname(rname);
			user.setSex(sex);
			user.setPhone(phone);
			user.sethobbies(hobbies);
			user.setintroduce(introduce);
			UserService  us=new UserService();
			int i=us.updateuserinfo(user);
			if(i>0) {
				request.getSession().setAttribute("name",user);
				response.sendRedirect("sc/cz-ss.jsp");
			}
			else {
				response.sendRedirect("sc/cz-fa.jsp");
				}
		}
	}

