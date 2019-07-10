<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User2 f=(User2)session.getAttribute("find"); %>
<h1>修改密码</h1>
<form name="form1" action="../updatepassServlet"  method="post" >
<input name="id" type="hidden" id="id" size="60" value="<%=f.getid()%>" >
  <p>密码
    <input type="password"  name="pass" id="pass" onblur="checkpass()">
  <label id="mess2"></label>
  </p>
  
   <!-- 确认密码 -->
  <p>确认密码
    <input type="password" placeholder="请确认你的密码"  name="repass" id="repass" onblur="checkrepass()">
  <label id="mess3"></label>
  </p>
  
 
  <input type="button" name="zc" id="zc" value="修改" onclick="check()">
  <input type="button"   value="返回" onclick="re()">
</form>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js">
 </script>
<script type="text/javascript">
function check(){
	 var pass=document.getElementById("pass").value;
	 var repass=document.getElementById("repass").value;
	 if(pass.length==0){
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
 function re(){
		history.go(-1);
	}
 </script>
</body>
</html>