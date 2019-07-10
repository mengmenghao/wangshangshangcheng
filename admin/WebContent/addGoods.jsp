<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Type"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 123 -->
<body>
<style type="text/css">
.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</style>
</HEAD>
<BODY>
<form action="AddGoodsServlet" enctype="multipart/form-data" id="form" name="form" method="post" >
  <p align="justify">商品名称：
    	<input type="text" name="goods_name" id="goods_name">
  </p>
  <p align="justify">商品类别：
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
  <p align="justify">商品图片：<input type="file" name="goods_pic" id="goods_pic"></p>
  <p align="justify">商品生产商：<input type="text" name="supplier" id="supplier"></p>
  <p align="justify">商品描述：<textarea name="goods_desc" cols="50" rows="5" id="goods_desc"></textarea></p>
  <p align="justify">商品价格：<input type="text" name="goods_price" id="goods_price"></p>
  <p align="justify">商品折扣率：<input type="text" name="goods_discount" id="goods_discount"></p>
  <p align="justify">库存数量：<input type="text" name="qty" id="qty"></p>
  <p align="justify">是否推荐商品：
  	<input type="radio" name="ispreferred" id="ispreferred" value="0">
     是
    <input type="radio" name="ispreferred" id="ispreferred" value="1">
     否
  </p>
  <p align="justify">
    <input type="submit" name="button" id="button" value="提交" onclick="check()">
    <input type="reset" name="button2" id="button2" value="重置">
    <input type="button" name="button3" id="button3" value="按钮" onclick="fanhui()">
  </p>
</form>  
<script type="text/javascript">
function check()
{	var goods_name=document.getElementById("goods_name").value;
	var supplier=document.getElementById("supplier").value;
	var goods_pic=document.getElementById("goods_pic").value;
	var goods_desc=document.getElementById("goods_desc").value;
	var goods_price=document.getElementById("goods_price").value;
	var qty=document.getElementById("qty").value;
	var ispreferred=document.getElementById("ispreferred").value;
	
		if(goods_name==null||goods_name==''){
		alert("商品名不能为空！");
		return false;
		}
		else if(supplier==null||supplier==''){
		alert("生产厂家不能为空！");
		return false;
		}
		else if(goods_pic==null||goods_pic==''){
		alert("商品图片不能为空！");
		return false;
		}
		else if(goods_desc==null||goods_desc==''){
		alert("商品描述不能为空！");
		return false;
		}
		else if(goods_price==null||goods_price==''){
		alert("商品价格不能为空！");
		return false;
		}
		else if(qty==null||qty==''){
		alert("库存数量不能为空！");
		return false;
		}
		else if(ispreferred==null||ispreferred==''){
		alert("请选择是否推荐商品！");
		return false;
		}else{
			document.getElementById("form").submit();
		}
		
}
function fanhui(){
	history.go(-1);
}
</script>
</body>
</html>