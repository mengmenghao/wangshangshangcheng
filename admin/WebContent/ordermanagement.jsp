<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cloor {
	color: #FF0000;
}
#button {
	font-weight: bold;
	background-color: #0FF;
	height:30px;
}
.bt {
	font-family: "华文琥珀";
}
a{
	text-decoration:none;
	color:#333;
}
.z {
	color: #F00;
}
.z2 {
	color: #F00;
}
.z3 {
	color: #F00;
}
.bu{
	font-weight: bold;
	background-color: #0FF;
	width:50px;
	height:30px;
	}
</style>
</head>
<body>
<%List<Order> orderlist=(List<Order>)session.getAttribute("orderlist");
	//UserService  userService=new UserService();
	//User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post" action="SelectOrderServlet">
  <p align="center">
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
    订单编号
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    用户名
    </label>
	<input type="checkbox" name="checkbox" id="checkbox3" value="2">
	<label for="checkbox3" class="z3">
    订单状态
    </label>
<input type="submit" value="查询" class="bu">
  </p>
<div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" align="center" class="cloor">订单编号</td>
        <td width="93" align="center" class="cloor">用户名</td> 
        <td width="93" align="center" class="cloor">订单日期</td>
        <!-- <td width="103" align="center" class="cloor">收获地址</td>
        <td width="103" align="center" class="cloor">收货人</td> -->
        <td width="103" align="center" class="cloor">邮政编码</td>
        <td width="103" align="center" class="cloor">订单总额</td>
        <td width="103" align="center" class="cloor">订单处理日期</td>
        <td width="93" align="center" class="cloor">订单状态</td>
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
       <%if(orderlist!=null){
    	 for(int i=0;i<orderlist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getOrder_id()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getUserName()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getOrderDate()%></td>
		<%-- <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getAddress() %></td>
		<td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getContactman() %></td> --%>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getPostcode()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getOrderSum()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getDealDate()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=orderlist.get(i).getStatus()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor">
          <a href="ViewDetailsOrderServlet?id=<%=orderlist.get(i).getOrder_id() %>">查看详情</a>
          <%if(orderlist.get(i).getStatus().equals("未完成")){%>
      			<a href="ShipServlet?id=<%=orderlist.get(i).getOrder_id()%>">发货</a>
		  <%} else{ %>
      			已发货
    		 <%
     		 }
    	  } 
    	 } 
    	 %> 
    </table>
 </div>
 </form> 
</body>
</html>