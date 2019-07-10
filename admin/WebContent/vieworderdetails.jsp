<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.OrdersDetail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
OrdersDetail orderd=(OrdersDetail)session.getAttribute("orderdetail");
%>
<form name="form1" method="post" action="">
  <p align="justify">订单号：<%=orderd.getOrder_id()%>
  </p>
  <p align="justify">订单行号：<%=orderd.getMum()%>  
  </p>
  <p align="justify">商品编号：<%=orderd.getGoods_id() %>
  </p>
  <p align="justify">商品图片：<img src="images/<%=orderd.getGoods_pic() %>" width="50" height="50">
  </p>
  <p align="justify">商品名称：<%=orderd.getGoods_name()%>
  </p>
  <p align="justify">商品价格：<%=orderd.getGoods_price() %>
  </p>
  <p align="justify">商品数量：<%=orderd.getQty()%>
  </p>
  <p align="justify">购买人：<%=orderd.getUserName() %>
  </p>
  <p align="justify">总结：<%=orderd.getGoods_price()*orderd.getQty() %>
  </p>
  <p align="justify">
    <input type="button" name="button3" id="button3" value="返回" onclick="fanhui()">
  </p>
</form>
<script type="text/javascript">
function fanhui(){
	history.go(-1);
}

</script>
</body>
</html>