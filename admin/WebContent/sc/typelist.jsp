<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

	.big{
	width:100%;
	height:1000px;
	float:left;
	background:#FC0;}
	
</style>
<body>
<%List<Type> typelist=(List<Type>)session.getAttribute("typelist");
%>
<div class="big">
  <div align="center">
    <table  border="1" >
      <div align="center">
        <%if(typelist!=null){
    	 for(int i=0;i<typelist.size();i++){
    %>
      </div>
      <tr class="xx">
        <td width="93" class="cloor"><div align="left"><%=i+1 %></div></td>
        <td width="103" class="cloor"><div align="left"><%=typelist.get(i).getType_name()%></div></td>
        <td width="150" class="cloor"><div align="left"><%=typelist.get(i).getType_desc()%></div></td>
        <td width="103" class="cloor">
        <div align="left"><a href="goodslist.jsp?id=<%=typelist.get(i).getType_id()%>">点击进入</a></div></td>
      </tr> 
      <div align="center">
        <%}
    	 }%>
        </div>
      </table>
  </div>
    	 </div>
</body>
</html>