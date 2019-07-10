<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.inputs{ width:50px;}
.big{
	width:100%;
	height:100%;
	background:#FC0;
	float:left;}
	.btn{float:right;
	 width:120px; 
	height:40px;
	 background:#F60;
	  border:1px #F60 solid;
	  color:#fff;
	   font-size:20px;
	   cursor:pointer;
	   margin-top:50px;
	   margin-left:50px;
	   margin-right:100px;}
</style>
</head>
<body>
<%List<Orders> Orders=(List<Orders>)session.getAttribute("Orders"); %>

<div class="big">
  <div align="center">
    <table  border="1" >
    <tr>
      <td width="103" class="cloor">订单编号</td>
      <td width="110" class="cloor">订单日期</td>
      <td width="150" class="cloor">收货地址</td>
      <td width="103" class="cloor">收货人</td>
      <td width="103" class="cloor">邮政编码</td>
        <td width="103" class="cloor">订单总额</td>
        <td width="103" class="cloor">订单处理日期</td>
       <td width="103" class="cloor">订单状态</td>
       <td width="103" class="cloor">订单详情</td>
      </tr>
<%if(Orders!=null){
    	 for(int i=0;i<Orders.size();i++){
    %>
      <tr class="xx">
      	<td width="103" class="cloor"><div align="left"><%=Orders.get(i).getOrder_id() %></div></td>
        <td width="110" class="cloor"><div align="left"><%=Orders.get(i).getOrderDate()%></div></td>
        <td width="150" class="cloor"><div align="left"><%=Orders.get(i).getAddress()%></div></td>
        <td width="103" class="cloor"><div align="left"><%=Orders.get(i).getContactman()%></div></td>
        <td width="103" class="cloor"><div align="left"><%=Orders.get(i).getPostcode()%></div></td>
      	<td width="103" class="cloor"><div align="left"><%=Orders.get(i).getOrderSum()%></div></td>
      	<td width="103" class="cloor"><div align="left"><%=Orders.get(i).getDealDate()%></div></td>
      	<td width="103" class="cloor"><div align="left"><%=Orders.get(i).getStatus()%></div></td>
      	<td width="103" class="cloor"><div align="left">
      		<a href="../ViewOrderServlet?id=<%=Orders.get(i).getOrder_id() %>">查看详情</a>
      	</div></td>
        <%}
    	 }%>
   </table>
   </div>
   </div>
<script type="text/javascript">
	
 </script>
</body>
</html>