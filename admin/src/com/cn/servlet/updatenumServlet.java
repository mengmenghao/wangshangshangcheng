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
 * Servlet implementation class updatenumServlet
 */
@WebServlet("/updatenumServlet")
public class updatenumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatenumServlet() {
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
		request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
		String goods_id=request.getParameter("id");
		int id=Integer.parseInt(goods_id);
		System.out.println(id);
		String goods_name=request.getParameter("name");
		System.out.println(goods_name);
		String goods_price=request.getParameter("price");
		float price=Float.parseFloat(goods_price);
		System.out.println(goods_price);
		String goods_discount=request.getParameter("discount");
		float discount=Float.parseFloat(goods_discount);
		String qty=request.getParameter("kc");
		int Qty=Integer.parseInt(qty);
		String num=request.getParameter("num");
		int Num=Integer.parseInt(num);
		System.out.println(num);
		String i=request.getParameter("i");
		int I=Integer.parseInt(i);
		String pic=request.getParameter("pic");
		shopcar car=new shopcar();
		car.setGoods_id(id);
		car.setGoods_name(goods_name);
		car.setGoods_price(price);
		car.setGoods_discount(discount);
		car.setQty(Qty);
		car.setNum(Num);
		car.setGoods_pic(pic);
		shopcar.set(I, car);
		response.sendRedirect("sc/shopcar.jsp");
	}

}
