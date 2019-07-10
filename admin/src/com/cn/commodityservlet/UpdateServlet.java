package com.cn.commodityservlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cn.service.CommodityService;
import com.cn.vo.Goods;

/**
 * Servlet implementation class UpdateServlet
 */
@MultipartConfig
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contextPath;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        contextPath = getServletContext().getRealPath("/");
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
		String goods_id=request.getParameter("goods_id");
		System.out.println("++"+goods_id);
		String  goods_name=request.getParameter("goods_name");
		String  type_id=request.getParameter("type");
		String  goods_price=request.getParameter("goods_price");
		String  goods_discount=request.getParameter("goods_discount");
		String  goods_desc=request.getParameter("goods_desc");
		String  supplier=request.getParameter("supplier");
		String  qty=request.getParameter("qty");
		String  ispreferred=request.getParameter("ispreferred");
		Part part = request.getPart("goods_pic"); 
		String fileName = getFileName(part);//获取文件名
		System.out.println("filename="+fileName);
	    writeTo(fileName, part);
	        //forward到显示	
	        
	    Goods goods = new Goods();
	    goods.setGoods_id(Integer.parseInt(goods_id));
	    goods.setGoods_name(goods_name);
		goods.setType_id(Integer.parseInt(type_id));
		goods.setGoods_price(Float.parseFloat(goods_price));
		goods.setGoods_discount(Float.parseFloat(goods_discount));
		goods.setGoods_desc(goods_desc);
		goods.setSupplier(supplier);
		goods.setQty(Integer.parseInt(qty));
		goods.setIspreferred(Integer.parseInt(ispreferred));
		goods.setGoods_pic(fileName);
	        
	    int i;
		CommodityService goodsService = new CommodityService();
		i=goodsService.Update(goods);
	    if(i>0) {
	    	List<Goods> list=goodsService.getAllGoods("","");
			request.getSession().setAttribute("goodslist",list);
	      	response.sendRedirect("commodity.jsp");
	     }else {
	        request.getRequestDispatcher("fail.jsp").forward(request, response);
	        }
	    }
	  
	//取得上传文件名
    private String getFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
//        String fileName = header.substring(header.lastIndexOf("\\")+1,
//        		header.indexOf(""));
        System.out.println("header----"+header);
        String fileName = header.substring(header.lastIndexOf("\\")+1,
                header.lastIndexOf("\""));
        System.out.println("文件名"+fileName);
        return fileName;
}

    private void writeTo(String fileName, Part part) throws IOException, FileNotFoundException {
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream(contextPath + fileName);
        byte[] buffer = new byte[1024];
        System.out.println("contextPath"+contextPath);
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }


}
