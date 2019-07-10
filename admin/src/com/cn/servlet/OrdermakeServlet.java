package com.cn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.service.OrdersService;
import com.cn.vo.Orders;
import com.cn.vo.User2;
import com.cn.vo.shopcar;

/**
 * Servlet implementation class OrdermakeServlet
 */
@WebServlet("/OrdermakeServlet")
public class OrdermakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdermakeServlet() {
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
		User2 u=(User2)session.getAttribute("name");
		SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=simpleDateFormat.format(new Date());
		float sum=0;
		if(shopcar!=null){
	    	 for(int i=0;i<shopcar.size();i++){
	    		 float sum_d=shopcar.get(i).getGoods_price()*shopcar.get(i).getGoods_discount()*shopcar.get(i).getNum();
	    		 sum+=sum_d;
	    	 }
	     }
		Orders order=new Orders();
		order.setUser_id(u.getid());
		order.setOrderDate(d);
		order.setOrderSum(sum);
		order.setStatus("未完成");
		order.setDealDate("未处理");
		OrdersService oService=new OrdersService();
		 int i=oService.neworder(order);
		 if(i>0) {
			 request.getSession().setAttribute("sum", order);
			 response.sendRedirect("sc/orderinfo.jsp");
		 }
	}

}
