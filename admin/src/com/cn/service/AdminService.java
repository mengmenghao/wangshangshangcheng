package com.cn.service;

import java.util.List;

import com.cn.dao.AdminDao;
import com.cn.vo.User;

public class AdminService {
	AdminDao uDao = null;

	public AdminService() {
		uDao = new AdminDao();
	}
	public User login(String name, String pass,String type) {
        return  uDao.selectUser(name, pass,type);
	}
	public List<User> getAllUser(String xuz,String query){
		return uDao.getAllUser(xuz,query);
	}
	public User getUserByName(String name){
		return uDao.getUserByName(name);
	}
	public int updateuser(String username,String password,String sex,String type,int id) {
		return uDao.updateUser(username, password,sex, type, id);
	}
	public int deletUser(int id) {
		return  uDao.deleteUser(id);
	}
	public User seleteUser(int id) {
		return  uDao.getview(id);
	}
	public int updateType(User u) {
		return uDao.updateType(u);
	}
	public int updateuserpass(String pass, String id) {//ÐÞ¸ÄÃÜÂë
		return uDao.updatePass(pass,id);
	}
}