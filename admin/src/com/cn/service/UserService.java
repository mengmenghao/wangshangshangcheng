package com.cn.service;

import com.cn.dao.Userdao;
import com.cn.vo.User2;

public class UserService {
	Userdao uDao =null;
	public UserService() {
		uDao = new Userdao();

	}
	public User2 Login (String name,String pass) {//��¼
		return  uDao.SelerctUser(name, pass);
	}
	public  int addUser (User2 u) {//ע��
		return  uDao.addUser(u);
	}
	public boolean checkUser(String name) {//���ض��ǲ�ѯ
		return uDao.checkUser(name);
	}
	public User2 find(String name) {//Ѱ���Ƿ��и��û�������������
		return uDao.findUser(name);
	}
	public int updateuserpass(String pass, String id) {//�޸�����
		return uDao.updatePass(pass,id);
	}
	public  int updateuserinfo (User2 u) {//�޸��û�������Ϣ
		return  uDao.updateUser(u);
	}
}
