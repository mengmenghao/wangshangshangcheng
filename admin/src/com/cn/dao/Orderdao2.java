package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.vo.shopcar;
import com.cn.db.JDBCUtil;
import com.cn.vo.Orders;
import com.cn.vo.OrdersDetail;
public class Orderdao2 {
	JDBCUtil j4=null;
	public Orderdao2() {
		j4=new JDBCUtil();
	}
	
	public  int addOrder(Orders o) {//Ìí¼Ó´ý¸¶¿î¶©µ¥
		String sql="insert into orders(user_id,orderDate,ordersum,status,dealDate) values(?,?,?,?,?)";
		Object params[]= {o.getUser_id(),o.getOrderDate(),o.getOrderSum(),o.getStatus(),o.getDealDate()};
		int  result=j4.updateData(sql, params);
		
		return  result;
	}
	public int updateOrder(Orders order) {//ÍêÉÆ¶©µ¥
		Object params[] = {order.getContactman(),order.getPostcode(),order.getAddress(),order.getNote(),order.getUser_id(),order.getOrderDate()};
		String sql = "update orders set contactman=?,postcode=?,address=?,note=? where user_id=? and orderDate=?";
		int  result=j4.updateData(sql, params);
		return result; 
	}
	public Orders selectOrder(Orders order) throws SQLException  {//²éÑ¯¶©µ¥ºÅ
		Object params[] = {order.getUser_id(),order.getOrderDate()};
		String sql = "select * from orders where user_id=? and orderDate=?";
		ResultSet  result=j4.QueryData(sql, params);
		Orders o=new Orders();
		try {
			if(result.next()) {
				o.setOrder_id(result.getInt("order_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return o; 
	}
	public  int addOrder_detail(Orders o_id, shopcar s) {//Ìí¼Ó¶©µ¥Í³¼Æ
		String sql="insert into order_detail(order_id,goods_id,goods_price,qty) values(?,?,?,?) ";
		Object params[]= {o_id.getOrder_id(),s.getGoods_id(),s.getGoods_price(),s.getNum()};
		int  result=j4.updateData(sql, params);
		
		return  result;
	}
	public  int deleteorder(Orders o) {//É¾³ý´ý¸¶¿î¶©µ¥
		String sql="delete from orders where user_id=? and orderDate=?";
		Object params[]= {o.getUser_id(),o.getOrderDate()};
		int  result=j4.updateData(sql, params);
		
		return  result;
	}
	public List<Orders> selectOrders(int i)  {//²éÑ¯¶©µ¥
		Object params[] = {i};
		String sql = "select * from orders where user_id=?";
		ResultSet  result=j4.QueryData(sql, params);
		List<Orders> list=new  ArrayList<Orders>();
		try {
			while(result.next()) {
				Orders o=new Orders();
				o.setOrder_id(result.getInt("order_id"));
				o.setOrderDate(result.getString("OrderDate"));
				o.setAddress(result.getString("address"));
				o.setContactman(result.getString("contactman"));
				o.setPostcode(result.getString("postcode"));
				o.setOrderSum(result.getFloat("orderSum"));
				o.setDealDate(result.getString("dealDate"));
				o.setStatus(result.getString("status"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return list; 
	}
	public List<OrdersDetail> viewOrders(int i)  {//²éÑ¯¶©µ¥
		Object params[] = {i};
		String sql = "select o.*,g.goods_pic,g.goods_name from order_detail o join goods g on o.goods_id=g.goods_id where order_id=?";
		ResultSet  r=j4.QueryData(sql, params);
		List<OrdersDetail> list=new  ArrayList<OrdersDetail>();
		try {
			while(r.next()) {
				OrdersDetail o=new OrdersDetail();
				o.setOrder_id(r.getInt("order_id"));
				o.setGoods_id(r.getInt("goods_id"));
				o.setGoods_name(r.getString("goods_name"));
				o.setGoods_pic(r.getString("goods_pic"));
				o.setGoods_price(r.getFloat("goods_price"));
				o.setMum(r.getInt("mum"));
				o.setQty(r.getInt("qty"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return list; 
	}

}
