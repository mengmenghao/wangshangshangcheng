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
 * Servlet implementation class UpdateTypeServlet
 */
@WebServlet("/UpdateTypeServlet")
public class UpdateTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTypeServlet() {
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
		
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String id=request.getParameter("id");
		
		Type type=new Type();	
		type.setType_name(name);
		type.setType_desc(desc);
		type.setType_id(Integer.parseInt(id));
		
		GoodsTypeService goodsTypeService=new GoodsTypeService();
		int i=goodsTypeService.updateType(type);
		//PrintWriter up=response.getWriter();
		if(i>0) {
			List<Type> list=goodsTypeService.getAllType("", "");
			request.getSession().setAttribute("typelist",list);
		}
		response.sendRedirect("goodstype.jsp");
	}

}
