package com.cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsService;
import com.cn.service.UserService;
import com.cn.vo.Goods;
import com.cn.vo.User2;
import com.cn.vo.shopcar;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		UserService us=new UserService();
		User2 f=us.Login(name,pass);
		List<shopcar> list=new  ArrayList<shopcar>();
		if(f!=null) {
			GoodsService gService=new GoodsService();
			List<Goods> g=gService.getAllGoods();
			request.getSession().setAttribute("shopcar",list);
			request.getSession().setAttribute("Allgoods",g);
			request.getSession().setAttribute("name",f);
			response.sendRedirect("sc/ss.jsp");
		}else {
			response.sendRedirect("sc/fa.jsp");
		}
	}

}
