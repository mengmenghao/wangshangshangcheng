package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.vo.shopcar;

/**
 * Servlet implementation class deleteshopcarServlet
 */
@WebServlet("/deleteshopcarServlet")
public class deleteshopcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteshopcarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  HttpSession session = request.getSession();
		  List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
		  String id=request.getParameter("id");
		  int i=Integer.parseInt(id);
	      shopcar.remove(i);
	      response.sendRedirect("sc/shopcar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
	}

}
