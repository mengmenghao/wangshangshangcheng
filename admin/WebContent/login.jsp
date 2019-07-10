<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<link rel="stylesheet" type="text/css" href="css/xiaoguo.css">
<style type="text/css">
.ziti {
	font-family: "华文中宋";
	font-size: 36px;
	font-weight: bold;
	color: #F00;
}
.ziti1 {
	font-size: 40px;
	color: #F00;
}
</style>
</head>
<body background="images/beiji.jpg">
<form name="form1" method="post" action="LoginAdminServlet">
  <div align="center" class="ziti1">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>管理员后台    </p>
  </div><div >
     <div align="center" class="ziti">
       <p>登录</p>
       <p><span class="yans">用户名</span>：
         <input id="name" name="name" class="inputs"  placeholder="请输入用户名" type="text"/>       
        </p><!--数值A输入框-->
        <p>密  码：<input id="pass" name="pass" class="inputs" placeholder="请输入密码" type="password"/>       
        </p>
       <p>
        <input type="submit" value="登录" class="btn" onClick="check()"/>
       </p>
     </div>
   </div>
</form>
</body>
<script type="text/javascript">
function check(){
var name=document.getElementById("name").value;
var pass=document.getElementById("pass").value;

if(name==""||pass==""){
	alert("用户名或者密码不能为空")
}else{
	 document.getElementById("form1").submit(); 
}
}

</script>
</html>