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
	public List<Type> getAllType() {//��ȡ�������
		return gDao.getAllType();
	}
	public List<Goods> getAllGoods() {//��ȡ������Ʒ
		return gDao.getAllGoods();
	}
	public shopcar getGoodsbyId(String id) {//ͨ��id��ȡָ����Ʒ
		return gDao.getGoodsbyId(id);
	}
	public int updateqty(shopcar car) {//�Ŀ��
		return gDao.updateqty(car);
	}
	
}
