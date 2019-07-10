package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.Goods;
import com.cn.vo.Type;
import com.cn.vo.shopcar;

public class Goodsdao {
	JDBCUtil j4=null;
	public Goodsdao() {
		j4=new JDBCUtil();
	}
	public List<Type> getAllType(){//找到全部类别
		Object params[] = {};
	String sql = "SELECT * from type ;";
	ResultSet rSet = j4.QueryData(sql, params);
	
	List<Type> list=new  ArrayList<Type>();
	try {
		while (rSet.next()) {
		  Type type=new Type();
		  type.setType_id(rSet.getInt("type_id"));
		  type.setType_name(rSet.getString("type_name"));
		  type.setType_desc(rSet.getString("type_desc"));
		  list.add(type);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;	
	}
	
	
	
	public List<Goods> getAllGoods() {//获取商品列表
		Object params[] = {};
		String sql = "SELECT * from goods";
		ResultSet rSet = j4.QueryData(sql, params);
		List<Goods> list=new  ArrayList<Goods>();
		try {
			while (rSet.next()) {
			  Goods goods=new Goods();
			  goods.setGoods_id(rSet.getInt("goods_id"));
			  goods.setType_id(rSet.getInt("Type_id"));
			  goods.setGoods_name(rSet.getString("goods_name"));
			  goods.setGoods_price(rSet.getFloat("goods_price"));
			  goods.setGoods_discount(rSet.getFloat("goods_discount"));
			  goods.setGoods_desc(rSet.getString("goods_desc"));
			  goods.setQty(rSet.getInt("qty"));
			  goods.setIspreferred(rSet.getInt("ispreferred"));
			  goods.setGoods_pic(rSet.getString("goods_pic"));
			  list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public shopcar getGoodsbyId(String id) {
		Object params[] = {id};
		String sql = "SELECT * from goods where goods_id=?";
		ResultSet rSet = j4.QueryData(sql, params);
		shopcar re=new shopcar();
		try {
			if(rSet.next()) {
			 re.setGoods_id(Integer.parseInt(id));
			 re.setGoods_name(rSet.getString("goods_name"));
			 re.setGoods_price(rSet.getFloat("goods_price"));
			 re.setGoods_discount(rSet.getFloat("goods_discount"));
			 re.setQty(rSet.getInt("qty"));
			 re.setGoods_pic(rSet.getString("goods_pic"));
			 re.setNum(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	public int updateqty(shopcar car) {//改库存
		Object params[] = {car.getQty()-car.getNum(),car.getGoods_id()};
		String sql = "update goods set qty=? where goods_id=?";
	   return j4.updateData(sql, params);

	}

}
