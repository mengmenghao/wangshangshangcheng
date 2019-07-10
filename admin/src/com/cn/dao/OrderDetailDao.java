package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.OrdersDetail;

public class OrderDetailDao {
	JDBCUtil  jb=null;
	public OrderDetailDao() {
		jb=new JDBCUtil();
	}
	public List<OrdersDetail> getAllOrder(String xuz, String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select order_detail.*,goods.goods_name,goods.goods_pic,userinfo.userName from order_detail,orders,goods,userinfo where order_detail.order_id=orders.order_id and order_detail.goods_id=goods.goods_id and orders.user_id=userinfo.user_id";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select DISTINCT order_detail.*,goods.goods_name,goods.goods_pic,userinfo.userName from order_detail,orders,goods,userinfo where order_detail.order_id=orders.order_id and order_detail.goods_id=goods.goods_id and orders.user_id=userinfo.user_id and userName like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select DISTINCT order_detail.*,goods.goods_name,goods.goods_pic,userinfo.userName from order_detail,orders,goods,userinfo where order_detail.order_id=orders.order_id and order_detail.goods_id=goods.goods_id and orders.user_id=userinfo.user_id and goods_name like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select order_detail.*,goods.goods_name,goods.goods_pic,userinfo.userName from order_detail,orders,goods,userinfo where order_detail.order_id=orders.order_id and order_detail.goods_id=goods.goods_id and orders.user_id=userinfo.user_id";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		ResultSet rSet= jb.QueryData(sql, params);
		List<OrdersDetail> list=new ArrayList<OrdersDetail>();
		try {
			while(rSet.next()) {
				OrdersDetail order=new OrdersDetail();
				order.setGoods_id(rSet.getInt("goods_id"));
				order.setGoods_name(rSet.getString("goods_name"));
				order.setGoods_pic(rSet.getString("goods_pic"));
				order.setUserName(rSet.getString("userName"));
				order.setGoods_price(rSet.getFloat("goods_price"));
				order.setMum(rSet.getInt("mum"));
				order.setOrder_id(rSet.getInt("order_id"));
				order.setQty(rSet.getInt("qty"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public OrdersDetail getview(int id) {
		String sql="select order_detail.*,goods.goods_name,goods.goods_pic,userinfo.userName from order_detail,orders,goods,userinfo where order_detail.order_id=orders.order_id and order_detail.goods_id=goods.goods_id and orders.user_id=userinfo.user_id and mum=?";
		Object params[] = {id};
		ResultSet rSet=jb.QueryData(sql, params);
		OrdersDetail order=new OrdersDetail();
		try {
			if(rSet.next()) {
				order.setGoods_id(rSet.getInt("goods_id"));
				order.setGoods_name(rSet.getString("goods_name"));
				order.setGoods_price(rSet.getFloat("goods_price"));
				order.setUserName(rSet.getString("userName"));
				order.setMum(rSet.getInt("mum"));
				order.setGoods_pic(rSet.getString("goods_pic"));
				order.setOrder_id(rSet.getInt("order_id"));
				order.setQty(rSet.getInt("qty"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
}
