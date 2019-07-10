package com.cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.service.GoodsService;
import com.cn.vo.Goods;
import com.cn.vo.shopcar;

/**
 * Servlet implementation class InshopcarServlet
 */
@WebServlet("/InshopcarServlet")
public class InshopcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InshopcarServlet() {
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
		HttpSession session = request.getSession();
		List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
		String goods_id=request.getParameter("id");
		GoodsService gService=new GoodsService();
		shopcar car=gService.getGoodsbyId(goods_id);
		shopcar.add(car);
		request.getSession().setAttribute("car", car);
		response.sendRedirect("sc/cz-ss.jsp");
	}

}
