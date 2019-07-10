package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.Type;

public class GoodsTypeDao {
	JDBCUtil  jb=null;
	public GoodsTypeDao() {
		jb=new JDBCUtil();
	}
	public  int addType(Type t) {
		String sql="insert into type(type_name,type_desc)values(?,?)";
		Object  params[]= {t.getType_name(),t.getType_desc()};
		int i=jb.updateData(sql, params);
		return i;
	}
	public List<Type> getAllUser(String xuz,String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select * from type";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select * from type where type_id like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select * from type where type_name like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select * from type where type_desc like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select * from type where type_id like ? or type_name like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select * from type where type_id like ? or type_desc like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select * from type where type_name like ? or type_desc like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select * from type where type_id like ? or type_name like ? or type_desc like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
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
	public int updateType(Type t) {
		String sql = "update type set type_name=?,type_desc=? where type_id=?";
		Object params[] = {t.getType_name(),t.getType_desc(),t.getType_id()};
	    return jb.updateData(sql, params);

	}
	public int Deletetype(int id) {
		String sql = "delete from type where type_id=?";
		Object params[] = {id};
	    return jb.updateData(sql, params);
	}
	public Type getview(int id) {
		String sql="select * from type where type_id=? ";
		Object params[] = {id};
		ResultSet rSet=jb.QueryData(sql, params);
		Type type=new Type();
		try {
			if(rSet.next()) {
				type.setType_id(rSet.getInt("type_id"));
				type.setType_name(rSet.getString("type_name"));
				type.setType_desc(rSet.getString("type_desc"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
}
