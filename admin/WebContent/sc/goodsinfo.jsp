<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
*{ margin:0px; padding:0px; margin-left:auto; margin-right:auto}
.big{
	width:100%;
	height:1000px;
	background:#FC0;
	float:left;}
.pic{
	float:left;
	width:300px;
	height:400px;
	margin-top:5%;
	margin-left:20%;
	}
.pri{
	background:#CCC;
	float:left;
	width:450px;
	height:400px;
	margin-top:5%;
	}
.ms{word-wrap: break-word;
word-break: break-all;
	width:450px;
	height:auto;}
	.jr{float:left;
	width:450px;
	height:200px;
	margin-top:5%;}
	.btn{ width:120px; 
	height:40px;
	 background:#F60;
	  border:1px #F60 solid;
	  color:#fff;
	   font-size:20px;
	   cursor:pointer;
	   margin-top:50px;
	   margin-left:50px;}
</style>
<body>
<%List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
List<Goods> Allgoods=(List<Goods>)session.getAttribute("Allgoods");
String id=request.getParameter("id"); 
int i=Integer.parseInt(id);
Goods g=Allgoods.get(i);
%>
  <form name="form1" method="post" action="../InshopcarServlet">
  <input name="id" type="hidden" id="id" size="60" value="<%=g.getGoods_id()%>" >
<div class="big">
<div class="pic">图片<img width="290" height="390"  src="../images/<%=g.getGoods_pic()%>"></div>
<div class="pri"><p>商品名：<%=g.getGoods_name()%></p>
<div class="ms">商品描述:<%=g.getGoods_desc()%></div>
<p>原价格：<%=g.getGoods_price()%></p>
<p>折扣：<%=g.getGoods_discount()%></p>
<p>现价：<%=g.getGoods_price()*g.getGoods_discount()%></p>
<p>库存数量：<%=g.getQty()%></p>
</div>
<div class="jr">

    <input type="submit" name="tj" id="tj" value="加入购物车" class="btn"></div></div>
  </form>
</body>
</html>