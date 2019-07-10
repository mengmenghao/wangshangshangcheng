<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#xq {
	font-family: "华文琥珀";
	font-weight: bold;
}
#button {
	font-weight: bold;
	font-family: "华文琥珀";
}
.neirong {
	font-family: "华文琥珀";
}
.time {
	font-family: "华文琥珀";
}
.headline {
	font-family: "华文琥珀";
}
.bt {
	font-family: "方正舒体";
}
.sj {
	font-family: "方正舒体";
}
.mainbody {
	font-family: "方正舒体";
}
</style>
</head>
<body>
<%
Order order=(Order)session.getAttribute("order");

%>
<form name="form1" method="post" action="ViewDetailsServlet">
  <table width="425" border="1" align="center">
    <tr>
      <th colspan="2" align="center" valign="middle" bgcolor="#99FFFF" scope="row" id="xq">详情</th>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">订单编号</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getOrder_id() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">用户编号</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getUser_id() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">用户名</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getUserName()%></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">订单日期</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getOrderDate() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">收货地址</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getAddress() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">收货人</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getContactman() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">邮政编码</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getPostcode() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">订单总额</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getOrderSum() %></td>
    </tr>
    <tr>
      <th bgcolor="#99FFFF" class="time" scope="row">订单处理日期</th>
      <td bgcolor="#FFFFFF" class="sj"><%=order.getDealDate() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">订单状态</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=order.getStatus() %></td>
    </tr>
    <tr>
      <th height="220" bgcolor="#99FFFF" class="neirong" scope="row">备注</th>
      <td bgcolor="#FFFFFF" class="mainbody"><%=order.getNote() %></td>
    </tr>
    <tr>
      <th colspan="2" bgcolor="#00FFFF" scope="row"><input type="button" name="button" id="button" value="返回" onclick="fanhui()"></th>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
<script type="text/javascript">
function fanhui(){
	history.go(-1);
}
</script>
</body>
</html>