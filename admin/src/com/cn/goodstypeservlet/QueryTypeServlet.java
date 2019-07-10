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
 * Servlet implementation class QueryTypeServlet
 */
@WebServlet("/QueryTypeServlet")
public class QueryTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTypeServlet() {
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
		GoodsTypeService userserciService =new GoodsTypeService();
		List<Type> list=userserciService.getAllType(xuz,qu);
	
		request.getSession().setAttribute("typelist",list);
		response.sendRedirect("goodstype.jsp");
		
	}

}
