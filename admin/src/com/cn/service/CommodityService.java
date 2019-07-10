package com.cn.service;

import java.util.List;

import com.cn.dao.CommodityDao;
import com.cn.vo.Goods;
import com.cn.vo.Type;

public class CommodityService {
	CommodityDao cDao = null;

	public CommodityService() {
		cDao = new CommodityDao();
	}
	public List<Type> selecttype(){
		return cDao.selecttype();
	}
	public int  AddGoods(Goods p) {
		return cDao.addGoods(p);
	}
	public List<Goods> getAllGoods(String xuz,String query){
		return cDao.getAllGoods(xuz,query);
	}
	public Goods updateGoods(int id){
		return cDao.updateGoods(id);
	}
	public int Update(Goods g) {
		return cDao.Update(g);
	}
	public int deleteGoods(int id) {
		return cDao.DeletGoods(id);
	}
}
