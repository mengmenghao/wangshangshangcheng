<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin:0px;padding:0px;}
#bt  {
	text-align:center;
	height:100px;
	line-height:100px;
	font-size: 36px;
	font-family: "微软雅黑";
	background:#FC0;
	margin:0px;padding:0px;
}
.pic{
	width:100%;
	float:left;
	position: absolute;}
.tp{
	 width:100%;  }
.tab{
	position: relative;
	z-index:2;
	width:500px;
	height:400px;
	background:#eee;
	margin-left:auto;
	margin-right:auto;}
.tab_title{
	height:30px;
	border-bottom:1px #333 solid;}
.yhm{
	height:80px;
	line-height:80px;}
	.mm{
	height:80px;}
.btn{ width:50px; height:30px; background:#F60; border:1px #F60 solid; color:#fff; font-size:20px; cursor:pointer; transition:0.5s; }
.btn-zh{ width:80px; height:30px; background:#F60; border:1px #F60 solid; color:#fff; font-size:20px; cursor:pointer; transition:0.5s; }
.btn：hover{ background:#f00}
.inputs{ height:30px; border:1px #ccc solid; padding-left:10px; padding-right:10px; transition:0.5s;}
.inputs:focus{ border:1px #f00 solid;}
</style>
</head>
<body>
<div id="bt">
  <div align="center">网上购物系统</div>
</div>
<div class="xx" id="xx">
  <div class="pic"><img src="../images/dl-p.jpg" height="403" class="tp"></div>
  <div class="tab">
<form name="form1" method="post" action="../LoginServlet">

	<div class="yhm">
    <p align="center">用户名：
    <label for="textfield"></label>
  <input type="text" placeholder="用户名" class="inputs" name="name" id="name" >
  </p>
</div>
<div class="mm">
  <p align="center">密码：
    <label for="textfield2"></label>
    <input type="password" placeholder="密码" class="inputs" name="pass" id="pass" >
  </p>
  
 
</div><div align="center">
  <p>
    <input type="button" name="dl" id="dl" value="登录" onClick="check()" class="btn" >
  </p>
  <p>&nbsp;</p>
</div>
</form><form name="form2" method="post" action="register.jsp">
 <p align="center">
    <input type="submit" name="button" id="zc" value="注册" class="btn">
  </p>
 </form>
  <p>&nbsp;</p>
 <form name="form3" method="post" action="zh.jsp">
 <p align="center">
    <input type="submit" name="button" id="zh" value="找回密码" class="btn-zh">
  </p>
 </form></div>
</div>
<script type="text/javascript">
 function check(){
	 var name=document.getElementById("name").value;
	 var pass=document.getElementById("pass").value;
	 if(name.length==0){
		 alert("请输入用户名");
	 }
	 else if(pass.length==0){
		 alert("请输入密码");
	 }
	 else {
		 form1.submit();
	 }
 }
 </script>

</body>
</html>