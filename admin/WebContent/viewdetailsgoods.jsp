<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Goods"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Goods goods=(Goods)session.getAttribute("goods");
%>
<form name="form1" method="post" action="">
<input type="hidden" name="goods_id" id="goods_id" value="<%=goods.getGoods_id()%>">
  <p align="justify">商品名称：<%=goods.getGoods_name()%>
  </p>
  <p align="justify">商品类别：<%=goods.getType_name()%>  
  </p>
  <p align="justify">商品图片：<img src="images/<%=goods.getGoods_pic() %>" width="50" height="50">
  </p>
  <p align="justify">商品生产商：<%=goods.getSupplier()%>
  </p>
  <p align="justify">商品描述：
    <textarea name="goods_desc" cols="50" rows="5" id="goods_desc"><%=goods.getGoods_desc() %></textarea>
  </p>
  <p align="justify">商品价格：<%=goods.getGoods_price()%>
  </p>
  <p align="justify">商品折扣率：<%=goods.getGoods_discount()%>
  </p>
  <p align="justify">库存数量：<%=goods.getQty()%>
  </p>
  <p align="justify">是否推荐商品：  <%=goods.getIspreferred()%>&nbsp;&nbsp;&nbsp;0:是，1:否
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