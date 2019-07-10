package com.cn.service;

import java.util.List;

import com.cn.dao.GoodsTypeDao;
import com.cn.vo.Type;

public class GoodsTypeService {
	GoodsTypeDao tDao = null;

	public GoodsTypeService() {
		tDao = new GoodsTypeDao();
	}
	public  int addType(Type t) {
		return tDao.addType(t);
	}
	public List<Type> getAllType(String xuz, String query) {
		return tDao.getAllUser(xuz, query);
	}
	public int updateType(Type t) {
		return tDao.updateType(t);
	}
	public int deletetype(int id) {
		return tDao.Deletetype(id);
	}
	public Type getview(int id) {
		return tDao.getview(id);
	}
}
