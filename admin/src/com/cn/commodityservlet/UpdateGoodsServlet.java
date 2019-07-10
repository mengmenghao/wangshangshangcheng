package com.cn.commodityservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cn.service.CommodityService;
import com.cn.vo.Goods;
import com.cn.vo.Type;

/**
 * Servlet implementation class UpdateGoodsServlet
 */
@WebServlet("/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goods_id=request.getParameter("id");
		System.out.println(goods_id);
		CommodityService commodityService =new CommodityService();
		List<Type> list=commodityService.selecttype();
		request.setAttribute("selecttype", list);
		Goods goods=commodityService.updateGoods(Integer.parseInt(goods_id));
		request.getSession().setAttribute("goods",goods);
		System.out.println(goods.getGoods_id());
		request.getRequestDispatcher("updateGoods.jsp").forward(request, response);
		//response.sendRedirect("updateGoods.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
