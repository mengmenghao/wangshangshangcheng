package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.Order;

public class OrderDao {
	JDBCUtil  jb=null;
	public OrderDao() {
		jb=new JDBCUtil();
	}
	public List<Order> getAllOrder(String xuz, String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where order_id like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where userName like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where status like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where order_id like ? or userName like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where order_id like ? or status like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where userName like ? or status like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where order_id like ? or userName like ? or status like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
		ResultSet rSet= jb.QueryData(sql, params);
		List<Order> list=new ArrayList<Order>();
		try {
			while(rSet.next()) {
				Order order=new Order();
				order.setAddress(rSet.getString("address"));
				order.setContactman(rSet.getString("contactman"));
				order.setDealDate(rSet.getString("dealDate"));
				order.setNote(rSet.getString("note"));
				order.setOrder_id(rSet.getInt("order_id"));
				order.setOrderDate(rSet.getString("orderDate"));
				order.setOrderSum(rSet.getFloat("orderSum"));
				order.setPostcode(rSet.getString("postcode"));
				order.setStatus(rSet.getString("status"));
				order.setUser_id(rSet.getInt("user_id"));
				order.setUserName(rSet.getString("userName"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateOrder(Order n) {
		String sql = "update orders set status=?,dealDate=? where order_id=?";
		Object params[] = {n.getStatus(),n.getDealDate(),n.getOrder_id()};
	    return jb.updateData(sql, params);
	}
	public Order getview(int id) {
		String sql="select o.*,u.userName from orders o join userinfo u on o.user_id=u.user_id where o.order_id=? ";
		Object params[] = {id};
		ResultSet rSet=jb.QueryData(sql, params);
		Order order=new Order();
		try {
			if(rSet.next()) {
				order.setAddress(rSet.getString("address"));
				order.setContactman(rSet.getString("contactman"));
				order.setDealDate(rSet.getString("dealDate"));
				order.setNote(rSet.getString("note"));
				order.setOrder_id(rSet.getInt("order_id"));
				order.setOrderDate(rSet.getString("orderDate"));
				order.setOrderSum(rSet.getFloat("orderSum"));
				order.setPostcode(rSet.getString("postcode"));
				order.setStatus(rSet.getString("status"));
				order.setUser_id(rSet.getInt("user_id"));
				order.setUserName(rSet.getString("userName"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
}
