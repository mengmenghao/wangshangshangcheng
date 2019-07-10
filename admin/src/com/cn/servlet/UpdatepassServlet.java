package com.cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.AdminService;

/**
 * Servlet implementation class updatepassServlet
 */
@WebServlet("/UpdatepassServlet")
public class UpdatepassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatepassServlet() {
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
		// ĞŞ¸ÄÃÜÂë
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		System.out.println(id);
		String pass=request.getParameter("pass");
		AdminService uService=new AdminService();
		int f=uService.updateuserpass(id,pass);
		if(f>0) {
			response.sendRedirect("re-ss.jsp");
		}
		else {
			response.sendRedirect("re-fa.jsp");
			}
	}
	}

