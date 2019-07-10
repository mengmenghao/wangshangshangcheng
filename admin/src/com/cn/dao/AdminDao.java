package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.JDBCUtil;
import com.cn.vo.User;

public class AdminDao {
	JDBCUtil  jb=null;
	public AdminDao() {
		jb=new JDBCUtil();
	}
	
	public  User  selectUser(String name,String pass,String type) {//µÇÂ¼
		String sql="select * from userinfo where userName=? and password=? and user_grade=?";
		Object params[]= {name,pass,type};
		ResultSet rSet= jb.QueryData(sql, params);
		User u=null;
		try {
			while(rSet.next()) {
				u=new User();
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setUser_grade(rSet.getString("user_grade"));
				u.setUser_Id(rSet.getInt("user_id"));
				u.setGender(rSet.getString("gender"));
				u.setRealName(rSet.getString("realName"));
				u.setHobbies(rSet.getString("hobbies"));
				u.setPhone(rSet.getString("phone"));
				u.setEmail(rSet.getString("email"));
				u.setQuestion(rSet.getString("question"));
				u.setAnswer(rSet.getString("answer"));
				u.setIntroduce(rSet.getString("introduce"));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	} 
	public List<User> getAllUser(String xuz,String query){
		String sql=null;
		Object params[]=null;
		if(query.equals("")) {
			sql="select * from userinfo";
			params= new Object[0];
		}else if(xuz.equals("0")){
			sql="select * from userinfo where userName like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("1")){
			sql="select * from userinfo where gender like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("2")){
			sql="select * from userinfo where user_grade like ?";
			params=new Object[1];
			params[0]="%"+query+"%";
			}
		else if(xuz.equals("01")){
			sql="select * from userinfo where userName like ? or gender like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			}
		else if(xuz.equals("02")){
			sql="select * from userinfo where userName like ? or user_grade like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("12")){
			sql="select * from userinfo where gender like ? or user_grade like ?";
			params=new Object[2];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			
			}
		else if(xuz.equals("012")){
			sql="select * from userinfo where user_grade like ? or gender like ? or userName like ?";
			params=new Object[3];
			params[0]="%"+query+"%";
			params[1]="%"+query+"%";
			params[2]="%"+query+"%";
			}
		ResultSet rSet= jb.QueryData(sql, params);
		List<User> list=new ArrayList<User>();
		try {
			while(rSet.next()) {
				User u=new User();
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setUser_grade(rSet.getString("user_grade"));
				u.setUser_Id(rSet.getInt("user_id"));
				u.setGender(rSet.getString("gender"));
				u.setRealName(rSet.getString("realName"));
				u.setHobbies(rSet.getString("hobbies"));
				u.setPhone(rSet.getString("phone"));
				u.setEmail(rSet.getString("email"));
				u.setQuestion(rSet.getString("question"));
				u.setAnswer(rSet.getString("answer"));
				u.setIntroduce(rSet.getString("introduce"));	
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public User getUserByName(String name) {
		String sql="select * from userinfo where userName=?";
		Object params[] = {name};
		ResultSet rSet=jb.QueryData(sql, params);
		User u=new User();
		try {
			if(rSet.next()) {
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setUser_grade(rSet.getString("user_grade"));
				u.setUser_Id(rSet.getInt("user_id"));
				u.setGender(rSet.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public  int updateUser(String username,String password,String sex,String type,int id) {
		String sql="update userinfo u set u.userName=?,u.password=?,u.gender=?,u.user_grade=? where u.user_id=?";
		Object params[] = {username,password,sex,type,id};
		int i=jb.updateData(sql, params);
		return i;
	}
	public  int deleteUser(int id) {
		String sql="delete from userinfo where user_id=?";
		Object params[] = {id};
		int i = jb.updateData(sql, params);
		return i;
	}
	public User getview(int id) {
		String sql="select *  from userinfo where user_id=? ";
		Object params[] = {id};
		ResultSet rSet=jb.QueryData(sql, params);
		User u=new User();
		try {
			if(rSet.next()) {
				u.setUserName(rSet.getString("username"));
				u.setPassword(rSet.getString("password"));
				u.setUser_grade(rSet.getString("user_grade"));
				u.setUser_Id(rSet.getInt("user_id"));
				u.setGender(rSet.getString("gender"));
				u.setRealName(rSet.getString("realName"));
				u.setHobbies(rSet.getString("hobbies"));
				u.setPhone(rSet.getString("phone"));
				u.setEmail(rSet.getString("email"));
				u.setQuestion(rSet.getString("question"));
				//u.setAnswer(rSet.getString("answer"));
				u.setIntroduce(rSet.getString("introduce"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	public int updateType(User u) {//¸ü¸Ä
		
		String sql = "update userinfo set user_grade = ?  where user_id = ?";
		Object params[] = {u.getUser_grade(),u.getUser_Id()};
		return jb.updateData(sql, params);
		
	}
	public int updatePass(String id,String pass) {//¸ÄÃÜÂë
		String sql = "update userinfo set password=? where user_id=?";
		Object params[] = {pass,id};
	   return jb.updateData(sql, params);

	}
}
