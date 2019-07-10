<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Goods,com.cn.vo.Type"%>
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
<form name="form1" enctype="multipart/form-data" method="post" action="UpdateServlet">
<input type="hidden" name="goods_id" id="goods_id" value="<%=goods.getGoods_id()%>">
  <p align="justify">商品名称：
    <input type="text" name="goods_name" id="goods_name" value="<%=goods.getGoods_name()%>">
  </p>
  <p align="justify">商品类别：
  	<input type="text" name="typetext" id="typetext" value="<%=goods.getType_name()%>">
   <select name="type" id="type">
      <%
			List<Type> list = (ArrayList<Type>)request.getAttribute("selecttype");
			for (Type type : list) {%>
      <option value="<%=type.getType_id()%>"><%=type.getType_name()%></option>
      <%
			}
			%>
    </select>
  </p>
  <p align="justify">商品图片：
    <input type="file" name="goods_pic" id="goods_pic"><img src="images/<%=goods.getGoods_pic() %>" width="50" height="50">
  </p>
  <p align="justify">商品生产商：
    <input type="text" name="supplier" id="supplier" value="<%=goods.getSupplier()%>">
  </p>
  <p align="justify">商品描述：
    <textarea name="goods_desc" cols="50" rows="5" id="goods_desc"><%=goods.getGoods_desc() %></textarea>
  </p>
  <p align="justify">商品价格：
    <input type="text" name="goods_price" id="goods_price" value="<%=goods.getGoods_price()%>">
  </p>
  <p align="justify">商品折扣率：
    <input type="text" name="goods_discount" id="goods_discount" value="<%=goods.getGoods_discount()%>">
  </p>
  <p align="justify">库存数量：
    <input type="text" name="qty" id="qty" value="<%=goods.getQty()%>">
  </p>
  <p align="justify">是否推荐商品：  
    <input type="text" name="ispreferred" id="ispreferred" value="<%=goods.getIspreferred()%>">0:是，1:否
    </p>
  <p align="justify">
    <input type="submit" name="button" id="button" value="提交" onclick="check()">
    <input type="reset" name="button2" id="button2" value="重置">
    <input type="button" name="button3" id="button3" value="返回" onclick="fanhui()">
  </p>
</form>
<script type="text/javascript">
function check(){
	document.getElementById("form1").submit();
}
function fanhui(){
	history.go(-1);
}

</script>
</body>
</html>