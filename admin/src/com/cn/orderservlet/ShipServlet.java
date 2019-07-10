package com.cn.orderservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.OrderService;
import com.cn.vo.Order;

/**
 * Servlet implementation class ShipServlet
 */
@WebServlet("/ShipServlet")
public class ShipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		OrderService ordereService=new OrderService();
		String order_id=request.getParameter("id");
		String status="ÒÑÍê³É";
		SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=simpleDateFormat.format(new Date());
		Order order=new Order();
		order.setDealDate(d);
		order.setStatus(status);
		order.setOrder_id(Integer.parseInt(order_id));
		int i = ordereService.updateOrder(order);
		if(i>0) {
			List<Order> list=ordereService.getAllOrder("","");
			request.getSession().setAttribute("orderlist",list);
		}
		response.sendRedirect("ordermanagement.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
