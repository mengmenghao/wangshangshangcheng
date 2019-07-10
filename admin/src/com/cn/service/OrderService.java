package com.cn.service;

import java.util.List;

import com.cn.dao.OrderDao;
import com.cn.vo.Order;

public class OrderService {
	OrderDao oDao = null;

	public OrderService() {
		oDao = new OrderDao();
	}
	public List<Order> getAllOrder(String xuz, String query) {
		return oDao.getAllOrder(xuz, query);
	}
	public int updateOrder(Order n) {
		return oDao.updateOrder(n);
	}
	public Order getview(int id) {
		return oDao.getview(id);
	}
}
