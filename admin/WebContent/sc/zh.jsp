<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 输入用户名，通过用户名寻找找回问题 -->
<form name="form1" method="post" action="../findServlet">
 <p align="center">用户名：
    <label for="textfield"></label>
  <input type="text" placeholder="请输入用户名" class="inputs" name="name" id="name" >
  </p>
  <p align="center">
    <input type="button" name="tj" id="tj" value="提交" onClick="check()" class="btn" >
  </p>
  </form>
  <script type="text/javascript">
 function check(){
	 var name=document.getElementById("name").value;
	 if(name.length==0){
		 alert("请输入用户名");
	 }
	 else {
		 form1.submit();
	 }
 }
 </script>
</body>
</html>