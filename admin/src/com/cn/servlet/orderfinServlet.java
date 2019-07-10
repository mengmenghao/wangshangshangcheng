package com.cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.service.GoodsService;
import com.cn.service.OrdersService;
import com.cn.vo.Orders;
import com.cn.vo.shopcar;

/**
 * Servlet implementation class orderfinServlet
 */
@WebServlet("/orderfinServlet")
public class orderfinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderfinServlet() {
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
		  Orders o=(Orders)session.getAttribute("sum");
		  String contactman=request.getParameter("contactman");
		  String postcode=request.getParameter("postcode");
		  String address=request.getParameter("address");
		  String note=request.getParameter("note");
		  Orders order=new Orders();
		  order.setContactman(contactman);
		  order.setPostcode(postcode);
		  order.setAddress(address);
		  order.setNote(note);
		  order.setUser_id(o.getUser_id());
		  order.setOrderDate(o.getOrderDate());
		  OrdersService oService=new OrdersService();
			int i=oService.updateorder(order);
			if(i>0) {
				Orders o_id = null;
				try {
					o_id = oService.selectorder(o);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int m=0;m<shopcar.size();m++) {
					shopcar s=new shopcar();
					s.setGoods_id(shopcar.get(m).getGoods_id());
					s.setQty(shopcar.get(m).getQty());
					s.setGoods_price(shopcar.get(m).getGoods_price()*shopcar.get(m).getGoods_discount());
					s.setNum(shopcar.get(m).getNum());
					int n=oService.addorder_detail(o_id, s);
					if(n>0) {
						GoodsService gService= new GoodsService();
						int l=gService.updateqty(s);
					}

				}
				
				shopcar.clear();
				 response.sendRedirect("sc/cz-ss.jsp");
			}
	}

}
