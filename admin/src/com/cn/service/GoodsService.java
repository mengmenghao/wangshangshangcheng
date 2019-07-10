package com.cn.service;

import java.util.List;

import com.cn.dao.Goodsdao;
import com.cn.vo.Type;
import com.cn.vo.shopcar;
import com.cn.vo.Goods;

public class GoodsService {
	Goodsdao gDao =null;
	public GoodsService() {
		gDao = new Goodsdao();

	}
	public List<Type> getAllType() {//获取所有类别
		return gDao.getAllType();
	}
	public List<Goods> getAllGoods() {//获取所有商品
		return gDao.getAllGoods();
	}
	public shopcar getGoodsbyId(String id) {//通过id获取指定商品
		return gDao.getGoodsbyId(id);
	}
	public int updateqty(shopcar car) {//改库存
		return gDao.updateqty(car);
	}
	
}
