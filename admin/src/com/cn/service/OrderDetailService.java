package com.cn.service;

import java.util.List;

import com.cn.dao.OrderDetailDao;
import com.cn.vo.OrdersDetail;

public class OrderDetailService {
	OrderDetailDao oDao = null;

	public OrderDetailService() {
		oDao = new OrderDetailDao();
	}
	public List<OrdersDetail> getAllOrder(String xuz, String query) {
		return oDao.getAllOrder(xuz, query);
	}
	public OrdersDetail getview(int id) {
		return oDao.getview(id);
	}
}
