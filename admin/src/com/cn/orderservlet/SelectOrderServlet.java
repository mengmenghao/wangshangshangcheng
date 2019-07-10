package com.cn.orderservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.OrderService;
import com.cn.vo.Order;

/**
 * Servlet implementation class SelectOrderServlet
 */
@WebServlet("/SelectOrderServlet")
public class SelectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOrderServlet() {
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
		request.setCharacterEncoding("utf-8");
		String qu=request.getParameter("query");
		String []checkbox=request.getParameterValues("checkbox");
		//System.out.println(sex);
		//System.out.println(checkbox.toString());
		String xuz="";
		if(checkbox==null) {
			xuz="012";
		}else {
			for(int i=0;i<checkbox.length;i++){
				xuz=xuz+checkbox[i];
			}
		}
		System.out.println(qu);
		System.out.println(xuz);
		OrderService ordereService=new OrderService();
		List<Order> list=ordereService.getAllOrder(xuz,qu);
		request.getSession().setAttribute("orderlist",list);
		response.sendRedirect("ordermanagement.jsp");
	}

}
