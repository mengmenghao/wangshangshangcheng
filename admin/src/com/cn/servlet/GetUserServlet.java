package com.cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cn.service.AdminService;
import com.cn.vo.User;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
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
		String name=request.getParameter("user");
		AdminService uService=new AdminService();
		User user=uService.getUserByName(name);
		System.out.println(user.getGender());
		Object sex = null;
		if(user.getGender().equals("ÄÐ")){
			sex=0;
		}else {
			sex=1;
		}
		JSONObject json=new JSONObject();
		json.put("id", user.getUser_Id());
		json.put("password", user.getPassword());
		json.put("username", user.getUserName());
		json.put("sex", sex);
		json.put("type", user.getUser_grade());
		response.setContentType("text/json");
		PrintWriter out=response.getWriter();
		out.write(json.toJSONString());
		out.flush();
		out.close();
	}

}
