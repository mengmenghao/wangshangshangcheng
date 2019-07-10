<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <%List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
String id=request.getParameter("id"); 
int i=Integer.parseInt(id);
shopcar s=shopcar.get(i);%>
</div>
<form name="form1" method="post" action="../updatenumServlet">
  <div align="center">
  <input name="id" type="hidden" id="id" size="60" value="<%=s.getGoods_id()%>" >
  <input name="name" type="hidden" id="name" size="60" value="<%=s.getGoods_name()%>" >
  <input name="price" type="hidden" id="price" size="60" value="<%=s.getGoods_price()%>" >
  <input name="discount" type="hidden" id="discount" size="60" value="<%=s.getGoods_discount()%>" >
    <input name="kc" type="hidden" id="kc" size="60" value="<%=s.getQty()%>" >
    <input name="pic" type="hidden" id="pic" size="60" value="<%=s.getGoods_pic()%>" >
    <input name="i" type="hidden" id="i" size="60" value="<%=i%>" >
  </div>
  <div>
    <div align="center">你加入购物车的商品：<%=s.getGoods_name() %>
    </div>
  </div>
  <div>
    <div align="center">单价为：<span id="jiage"><%=s.getGoods_price()*s.getGoods_discount() %></span>
    </div>
  </div>
  <div>
    <div align="center">
      <input type="text" value="<%=s.getNum() %>" id="num" name="num" class="inputs" >
      (库存为<span id="kucun"><%=s.getQty()%></span>件)
    </div>
  </div>
  
  <div align="center">
    <input type="button" value="确定" onClick="check()">
  </div>
</form>
  <div align="center">
    <script type="text/javascript">
function check(){
	var num = document.getElementById("num").value;
	var kucun = document.getElementById("kc").value;
	
	if(isNaN(Number(num))){
		alert("请输入正确的数值");
}
	else if(Number(num)>Number(kucun)){
	alert("库存数量不足，请减少购买量");
	}
	else{
		form1.submit(); 
	}
	}

  </script>
  </div>
</body>
</html>