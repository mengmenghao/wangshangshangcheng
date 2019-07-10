package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.db.JDBCUtil;

import com.cn.vo.User2;

public class Userdao {
	JDBCUtil j4=null;
	public Userdao() {
		j4=new JDBCUtil();
	}
	public User2 SelerctUser(String name,String pass) {//查询，登录
		String sql="select * from userinfo where userName=? and password=? ";
		Object  param[]= {name,pass};
		ResultSet  rSet=j4.QueryData(sql, param);
		User2 re=null;
		try {
			if(rSet.next()) {
				re=new User2();
				re.setid(rSet.getInt("user_id"));
				re.setname(rSet.getString("userName"));
				re.setpass(rSet.getString("password"));
				re.setSex(rSet.getString("gender"));
				re.setRname(rSet.getString("realName"));
				re.sethobbies(rSet.getString("hobbies"));
				re.setPhone(rSet.getString("phone"));
				re.setEmail(rSet.getString("email"));
				re.setintroduce(rSet.getString("introduce"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  re;
	}
	public User2 findUser(String name) {//查询找回问题
		String sql="select * from userinfo where userName=?";
		Object  param[]= {name};
		ResultSet  rSet=j4.QueryData(sql, param);
		User2 re=null;
		try {
			if(rSet.next()) {
				re=new User2();
				re.setid(rSet.getInt("user_id"));
				re.setname(rSet.getString("userName"));
				re.setpass(rSet.getString("password"));
				re.setZh_wt(rSet.getString("question"));
				re.setZh_da(rSet.getString("answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  re;
	}
	public  int addUser(User2 u) {//注册
		String sql="insert into userinfo(userName,password,email,realName,gender,question,answer,phone,hobbies,introduce) values(?,?,?,?,?,?,?,?,?,?)";
		Object params[]= {u.getname(),u.getpass(),u.getEmail(),u.getRname(),u.getSex(),u.getZh_wt(),u.getZh_da(),u.getPhone(),u.gethobbies(),u.getintroduce()};
		int  result=j4.updateData(sql, params);
	
		return  result;
	}
	public boolean checkUser(String name) {//查重名
		String sql="select * from userinfo where userName=?";
		Object params[]= {name}; 
		ResultSet rSet=j4.QueryData(sql, params);
		boolean f=false;
		try {
			if(rSet.next()) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	public int updatePass(String id,String pass) {//改密码
		Object params[] = {pass,id};
		String sql = "update userinfo set password=? where user_id=?";
	   return j4.updateData(sql, params);

	}
	public int updateUser(User2 user) {//更改个人资料
			Object params[] = {user.getname(),user.getEmail(),user.getRname(),user.getSex(),user.getPhone(),user.gethobbies(),user.getintroduce(),user.getid()};
			String sql = "update userinfo set userName=?,email=?,realName=?,gender=?,phone=?,hobbies=?,introduce=? where user_id=?";
		   return j4.updateData(sql, params);

	}
}
