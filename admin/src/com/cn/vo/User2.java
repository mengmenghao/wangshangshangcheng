package com.cn.vo;

	public class User2 {
		private  int user_id;
		private  String userName;
		private  String realName;
		private  String password;
		private  String  gender;
		private  String  email;
		private  String  phone;
		private  String hobbies;
		private  String  introduce;
		private  String  zh_wt;
		private  String  zh_da;
		private  String  user_grade;
		public User2(int user_id,String userName, String realName, String password, String gender,String email,String  phone, String hobbies, String introduce,String  user_grade) {
			// TODO Auto-generated constructor stub
			this.user_id=user_id;
			this.userName=userName;
			this.password=password;
			this.realName=realName;
			this.gender=gender;
			this.email=email;
			this.hobbies=hobbies;
			this.introduce=introduce;
			this.user_grade=user_grade;
		}
		public String getRname() {
			return realName;
		}
		public void setRname(String rname) {
			this.realName = rname;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public String getZh_wt() {
			return zh_wt;
		}
		public void setZh_wt(String zh_wt) {
			this.zh_wt = zh_wt;
		}
		public String getZh_da() {
			return zh_da;
		}
		public void setZh_da(String zh_da) {
			this.zh_da = zh_da;
		}
		public User2() {};
		public String getname() {
			return userName;
		}
		public void setname(String name) {
			this.userName = name;
		}
		public String getpass() {
			return password;
		}
		public void setpass(String pass) {
			this.password = pass;
		}
		public String getSex() {
			return gender;
		}
		public void setSex(String gender) {
			this.gender = gender;
		}
		public String gethobbies() {
			return hobbies;
		}
		public void sethobbies(String hobbies) {
			this.hobbies = hobbies;
		}
		public String getintroduce() {
			return introduce;
		}
		public void setintroduce(String introduce) {
			this.introduce = introduce;
		}
		public String getuser_grade() {
			return user_grade;
		}
		public void setuser_grade(String user_grade) {
			this.user_grade = user_grade;
		}
		public int getid() {
			return user_id;
		}
		public void setid(int id) {
			this.user_id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	}

