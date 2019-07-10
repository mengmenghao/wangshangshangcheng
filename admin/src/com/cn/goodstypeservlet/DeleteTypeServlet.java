package com.cn.goodstypeservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsTypeService;
import com.cn.vo.Type;

/**
 * Servlet implementation class DeleteTypeServlet
 */
@WebServlet("/DeleteTypeServlet")
public class DeleteTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		GoodsTypeService goodsTypeService=new GoodsTypeService();
		int i = goodsTypeService.deletetype(Integer.parseInt(id));
		if(i>0) {
			List<Type> list=goodsTypeService.getAllType("", "");
			request.getSession().setAttribute("typelist",list);
		}
		response.sendRedirect("goodstype.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
