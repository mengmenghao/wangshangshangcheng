package com.cn.service;

import com.cn.dao.Userdao;
import com.cn.vo.User2;

public class UserService {
	Userdao uDao =null;
	public UserService() {
		uDao = new Userdao();

	}
	public User2 Login (String name,String pass) {//登录
		return  uDao.SelerctUser(name, pass);
	}
	public  int addUser (User2 u) {//注册
		return  uDao.addUser(u);
	}
	public boolean checkUser(String name) {//查重而非查询
		return uDao.checkUser(name);
	}
	public User2 find(String name) {//寻找是否有该用户，无其他功能
		return uDao.findUser(name);
	}
	public int updateuserpass(String pass, String id) {//修改密码
		return uDao.updatePass(pass,id);
	}
	public  int updateuserinfo (User2 u) {//修改用户个人信息
		return  uDao.updateUser(u);
	}
}
