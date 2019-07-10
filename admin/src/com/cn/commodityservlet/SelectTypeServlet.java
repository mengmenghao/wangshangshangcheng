package com.cn.commodityservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.CommodityService;
import com.cn.vo.Type;

/**
 * Servlet implementation class SelectTypeServlet
 */
@WebServlet("/SelectTypeServlet")
public class SelectTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TypeBiz typeDao=new TypeBizImpl();
		//List<TypeVo> ls=typeDao.getBookType();
		CommodityService commodityService =new CommodityService();
		List<Type> list=commodityService.selecttype();
		request.setAttribute("selecttype", list);
		request.getRequestDispatcher("addGoods.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
