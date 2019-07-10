package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.Goods;
import com.cn.vo.Type;

public class CommodityDao {
	JDBCUtil  jb=null;
	public CommodityDao() {
		jb=new JDBCUtil();
	}
	public List<Type> selecttype(){
		String sql="select * from type";
		Object params[]= {};
		ResultSet rSet= jb.QueryData(sql, params);
		List<Type> list=new ArrayList<Type>();
		try {
			while(rSet.next()) {
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
	public  int addGoods(Goods g) {
		String sql="insert into goods(goods_name,type_id,goods_price,goods_discount,goods_desc,supplier,qty,ispreferred,goods_pic)values(?,?,?,?,?,?,?,?,?)";
		Object  params[]= {g.getGoods_name(),g.getType_id(),g.getGoods_price(),g.getGoods_discount(),g.getGoods_desc(),g.getSupplier(),g.getQty(),g.getIspreferred(),g.getGoods_pic()};
		int i=jb.updateData(sql, params);
		return i;
	}
	public List<Goods> getAllGoods(String xuz,String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id where type_name like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id where goods_name like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id where goods_desc like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id where type_name like ? or goods_name like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select g.*,t.type_name from goods g join type t on g.type_id=t.type_id where type_name like ? or goods_desc like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select g.*,t.type_name from type t join goods g on g.type_id=t.type_id where goods_name like ? or goods_desc like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select g.*,t.type_name from type t join goods g on g.type_id=t.type_id where type_name like ? or goods_name like ? or goods_desc like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
		ResultSet rs=jb.QueryData(sql, params);
		List<Goods> list=new ArrayList<Goods>();
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_discount(rs.getFloat("goods_discount"));
				goods.setGoods_desc(rs.getString("goods_desc"));
				goods.setGoods_pic(rs.getString("goods_pic"));
				goods.setGoods_price(rs.getFloat("goods_price"));
				goods.setIspreferred(rs.getInt("ispreferred"));
				goods.setQty(rs.getInt("qty"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setType_id(rs.getInt("type_id"));
				goods.setType_name(rs.getString("type_name"));
				list.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Goods updateGoods(int id) {
		String sql="select g.*,t.type_name from type t join goods g on g.type_id=t.type_id where goods_id=?";
		Object params[] = {id};
		ResultSet rs=jb.QueryData(sql, params);
		Goods goods=new Goods();
		try {
			if(rs.next()) {
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_discount(rs.getFloat("goods_discount"));
				goods.setGoods_desc(rs.getString("goods_desc"));
				goods.setGoods_pic(rs.getString("goods_pic"));
				goods.setGoods_price(rs.getFloat("goods_price"));
				goods.setIspreferred(rs.getInt("ispreferred"));
				goods.setQty(rs.getInt("qty"));
				goods.setSupplier(rs.getString("supplier"));
				goods.setType_id(rs.getInt("type_id"));
				goods.setType_name(rs.getString("type_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}
	public int Update(Goods g) {
		String sql = "update goods set goods_name=?,goods_discount=?,goods_desc=?,goods_pic=?,goods_price=?,ispreferred=?,qty=?,supplier=?,type_id=? where goods_id=?";
		Object params[] = {g.getGoods_name(),g.getGoods_discount(),g.getGoods_desc(),g.getGoods_pic(),g.getGoods_price(),g.getIspreferred(),g.getQty(),g.getSupplier(),g.getType_id(),g.getGoods_id()};
	    return jb.updateData(sql, params);

	}
	public int DeletGoods(int id) {
		String sql = "delete from goods where goods_id=?";
		Object params[] = {id};
	    return jb.updateData(sql, params);
	}

	
}
