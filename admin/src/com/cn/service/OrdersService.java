package com.cn.service;

import java.sql.SQLException;
import java.util.List;

import com.cn.dao.Orderdao2;
import com.cn.vo.Orders;
import com.cn.vo.OrdersDetail;
import com.cn.vo.shopcar;

public class OrdersService {
	Orderdao2 oDao =null;
	public OrdersService() {
		oDao = new Orderdao2();

	}
	public int neworder(Orders order) {
		return oDao.addOrder(order); 
	}
	public int updateorder(Orders order) {
		return oDao.updateOrder(order); 
	}
	public Orders selectorder(Orders order) throws SQLException {
		return oDao.selectOrder(order); 
	}
	public int addorder_detail(Orders o_id, shopcar order) {
		return oDao.addOrder_detail(o_id,order); 
	}
	public int deleteorder(Orders order) {
		// TODO Auto-generated method stub
		return oDao.deleteorder(order);
	}
	public List<Orders> selectorders(int i) {
		return oDao.selectOrders(i); 
	}
	public List<OrdersDetail> viewOrders(int i)  {
		return oDao.viewOrders(i);
	}
}
