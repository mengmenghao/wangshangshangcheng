<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.User,com.cn.vo.Goods"%>
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
	List<Goods> goodslist=(List<Goods>)session.getAttribute("goodslist");
	//UserService  userService=new UserService();
	User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post">
  <p align="center">
  	<strong>
   	 <input type="button" name="button" id="button" onclick="addGoods()" value="添加商品">
  	</strong> 
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
    商品类别
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    商品名称
    </label>
	<input type="checkbox" name="checkbox" id="checkbox3" value="2">
	<label for="checkbox3" class="z3">
    商品详情
    </label>

<input type="submit" value="查询" class="bu" onclick="QueryGoods()">
  </p>
  <div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" align="center" class="cloor">商品图片</td>
        <td width="203" align="center" class="cloor">商品名称</td>
        <td width="203" align="center" class="cloor">商品类别</td>
        <td width="93" align="center" class="cloor">商品描述</td>
        <td width="93" align="center" class="cloor">商品价格</td>
        <td width="93" align="center" class="cloor">商品库存</td>
        <td width="93" align="center" class="cloor">是否推荐商品</td>
        <!-- <td width="103" align="center" class="cloor">发布时间</td> -->
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
      <%if(goodslist!=null){
    	 for(int i=0;i<goodslist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><img src="images/<%=goodslist.get(i).getGoods_pic()%>" width="50" height="50"></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getGoods_name()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getType_name() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getGoods_desc() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getGoods_price()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getQty() %></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=goodslist.get(i).getIspreferred() %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor">
          <a href="UpdateGoodsServlet?id=<%=goodslist.get(i).getGoods_id()%>">修改</a>
          <a href="DeleteGoodsServlet?id=<%=goodslist.get(i).getGoods_id()%>">删除</a>
          <a href="ViewDetailsGoodsServlet?id=<%=goodslist.get(i).getGoods_id() %>">查看详情</a>
</td>
      </tr>
      <% }
    	 } 
    	 %>
    </table>
  </div>
</form>
<script type="text/javascript">
function addGoods(){
	window.location.href="SelectTypeServlet";
}
function QueryGoods(){
	form1.action="QueryGoodsServlet";
	form1.submit();
}
</script>
</html>