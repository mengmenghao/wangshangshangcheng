<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.OrdersDetail"%>
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
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<body >
<%
	List<OrdersDetail> ordersdetaillist=(List<OrdersDetail>)session.getAttribute("detaillist");
	//UserService  userService=new UserService();
	//User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post" action="OrderDetaServlet">
  <p align="center"> 
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
    用户名
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    商品名称
    </label>

<input type="submit" value="查询" class="bu">
  </p>
  <div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" align="center" class="cloor">订单编号</td>
        <td width="103" align="center" class="cloor">订单行号</td>
        <td width="103" align="center" class="cloor">商品编号</td>
        <td width="103" align="center" class="cloor">商品图片</td>
        <td width="93" align="center" class="cloor">商品名称</td>
        <td width="93" align="center" class="cloor">商品价格</td>
        <td width="93" align="center" class="cloor">购买商品数量</td>
         <td width="93" align="center" class="cloor">购买人</td>
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
      <%if(ordersdetaillist!=null){
    	 for(int i=0;i<ordersdetaillist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getOrder_id()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getMum() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getGoods_id() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><img src="images/<%=ordersdetaillist.get(i).getGoods_pic() %>" width="50" height="50"></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getGoods_name()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getGoods_price() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getQty() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=ordersdetaillist.get(i).getUserName()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor">
          <a href="ViewOrderDetailServlet?id=<%=ordersdetaillist.get(i).getMum() %>">查看详情</a>
</td>
      </tr>
      <% }
    	 } 
    	 %>
    </table>
  </div>
</form>
</body>
</html>