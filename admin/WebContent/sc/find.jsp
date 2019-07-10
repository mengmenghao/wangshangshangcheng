<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User2 f=(User2)session.getAttribute("find");%>
<input name="id" type="hidden" id="ranswer" size="60" value="<%=f.getZh_da()%>" >
   <!-- 通过输入问题答案判断身份，并跳转至修改密码 -->
<h1 align="center">请输入问题答案</h1>
       <p align="center">找回问题
    <input type="text" name="question" id="question" value=<%=f.getZh_wt() %> readonly>
  </p>
  <form name="form1" method="post" action="updatepass.jsp">
  <p align="center">请输入答案
    <input type="text" name="answer" id="answer" >
  </p>
  <p align="center">
    <input type="button" name="tj" id="tj" value="提交" onClick="check()" >
  </p>
  </form>
  <script type="text/javascript">
 function check(){
	 var question=document.getElementById("question").value;
	 var answer=document.getElementById("answer").value;
	 var ranswer=document.getElementById("ranswer").value;
	 if(answer.length==0){
		 alert("请输入答案");
	 }
	 else if(answer!=ranswer){
		 alert("答案输入错误");
	 }
	 else {
		 form1.submit();
	 }
 }
 </script>
</body>
</html>