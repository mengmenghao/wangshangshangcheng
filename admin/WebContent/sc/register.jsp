<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">用户注册</h1>
<form name="form1" action="../Registerservlet"  method="post" >
  <div align="center"><!-- 用户名 -->
  </div>
  <p align="center">用户名
    <input type="text" placeholder="请输入用户名"  name="name" id="name" onblur="checkuser()">
    <label id="mess1"></label>
  </p>
  <div align="center"><!-- 密码 -->
  </div>
  <p align="center">密码
    <input type="password" placeholder="密码不少于6位，不多于18位"  name="pass" id="pass" onblur="checkpass()">
  <label id="mess2"></label>
  </p>
  
   <div align="center">
     <!-- 确认密码 -->
   </div>
  <p align="center">确认密码
    <input type="password" placeholder="请确认你的密码"  name="repass" id="repass" onblur="checkrepass()">
  <label id="mess3"></label>
  </p>
  
   <div align="center">
     <!-- 性别 -->
   </div>
  <p align="center">性别<input type="radio" name="sex" id="sex" value="男">男
  		<input type="radio" name="sex"  id="sex" value="女">女
   
  </p>
   <p align="center">爱好<input type="checkbox" name="hobb" id="hobb" value="游戏">游戏
  <input type="checkbox" name="hobb" id="hobb" value="读书">读书
  <input type="checkbox" name="hobb" id="hobb" value="运动">运动
  <input type="checkbox" name="hobb" id="hobb" value="购物">购物
  <input type="checkbox" name="hobb" id="hobb" value="其他">其他
  </p>
  
	 <div align="center"><!-- 个人简介 -->
  </div>
  <p align="center">个人简介
  	<textarea name="introduce" id="textarea" cols="45" rows="5"></textarea>
  </p>
  <div align="center">
    <p>请选择找回密码的问题
      <select name="zh_wt" id="zh_wt">
      <option value="你父亲的名字是什么？">你父亲的名字是什么？</option>
    <option value="你母亲的名字是什么？">你母亲的名字是什么？</option>
    <option value="你的生日是多少？">你的生日是多少？</option>
      </select>
   </p>
    <p align="center">请输入问题的答案
    <input type="password" placeholder="请输入你的答案"  name="zh_da" id="zh_da" >
  <label id="mess4"></label>
  </p>
  <p align="center">真实姓名
    <input type="text" placeholder="请输入你的真实姓名"  name="rname" id="rname">
  </p>
  <p align="center">联系电话
    <input type="text" placeholder="请输入你的联系电话"  name="phone" id="phone">
  </p>
  <p align="center">电子邮件
    <input type="text" placeholder="请输入你的电子邮件"  name="email" id="email">
  </p>
    <input type="button" name="zc" id="zc" value="注册" onclick="check()">
     <input type="button" name="fh" id="fh" value="返回" onclick="re()">
  </div>
</form>
 <div align="center">
   <script type="text/javascript" src="js/jquery-3.2.1.min.js">
 </script>
</div>
 <script type="text/javascript">
function check(){
	 var name=document.getElementById("name").value;
	 var pass=document.getElementById("pass").value;
	 var repass=document.getElementById("repass").value;
	 if(name.length==0){
		 alert("请输入用户名");
	 }
	 else if(pass.length==0){
		 alert("请输入密码");
	 }
	 else if(pass!=repass){
		 alert("确认密码与密码不符合");
	 }
	 else {
		 form1.submit();
	 }
}
function checkpass(){
	 var pass=document.getElementById("pass").value;
	 if(pass.length<6 || pass.length>18){
		 $("#mess2").text("密码不符合要求");
	 }
	 else{
		 $("#mess2").text("");
	 }
}
 
 function checkrepass(){
	 var pass=document.getElementById("pass").value;
	 var repass=document.getElementById("repass").value;
	if(pass!=repass){
		$("#mess3").text("确认密码与密码不符合");
	 }
	else{
		 $("#mess3").text("");
	 }
 }
function checkuser(){
		var name=document.getElementById("name").value;
		if(name==""){
			$("#mess1").text("请输入用户名");
		 }else{
		$.post("checkServlet",{"name":name},function(data){
		if(data=='no'){
		$("#mess1").text("该用户名可用");
		}else{
			$("#mess1").text("该用户名不可用");
		}
			
		});
	}
}
function re(){
	history.go(-1);
}
 </script>
</body>
</html>