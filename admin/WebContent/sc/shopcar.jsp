<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.inputs{ width:50px;}
.big{
	width:100%;
	height:1000px;
	background:#FC0;
	float:left;}
	.btn{float:right;
	 width:120px; 
	height:40px;
	 background:#F60;
	  border:1px #F60 solid;
	  color:#fff;
	   font-size:20px;
	   cursor:pointer;
	   margin-top:50px;
	   margin-left:50px;
	   margin-right:100px;}
</style>
</head>
<body>
<%List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");%>
<form name="form1" method="post" action="../OrdermakeServlet">
<div class="big">
  <div align="center">
    <table  border="1" >
    <tr>
      <td width="103" class="cloor">图片</td>
      <td width="110" class="cloor">商品名字</td>
      <td width="103" class="cloor">单价</td>
      <td width="150" class="cloor">数量</td>
      <td width="103" class="cloor">操作</td>
      </tr>
<%if(shopcar!=null){
    	 for(int i=0;i<shopcar.size();i++){
    %>
    <input name="kc" type="hidden" id="kc" size="60" value="<%=shopcar.get(i).getQty()%>" >
    <input name="kc" type="hidden" id="xh" size="60" value="<%=i%>" >
      <tr class="xx">
      	<td width="103" class="cloor"><div align="left"><img height="100" src="../images/<%=shopcar.get(i).getGoods_pic() %>"></div></td>
        <td width="110" class="cloor"><div align="left"><%=shopcar.get(i).getGoods_name()%></div></td>
        <td width="103" class="cloor"><div align="left"><%=shopcar.get(i).getGoods_price()*shopcar.get(i).getGoods_discount()%></div></td>
        <td width="150" class="cloor"><div align="left"><%=shopcar.get(i).getNum() %>
		<a href="num.jsp?id=<%=i %>">修改数量</a></td>
      <td width="103" class="cloor">
        <div align="left"><a href="../deleteshopcarServlet?id=<%=i%>">删除</a></div></td>
      </tr> 
      
        <%}
    	 }%>
   </table>
   </div>
    <input type="submit" name="tj" id="tj" value="购买" class="btn">
   </div>
   </form>
<script type="text/javascript">
	
 </script>
</body>
</html>