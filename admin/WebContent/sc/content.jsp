<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin:0px;padding:0px;}
.sp{
	width:25%;
	height:300px;
	float:left;
	margin-left:50px;
	margin-top:50px;
	background:#0CF;		
	}
.rm{
	font-size:24px;
	font-color:red;
	font-family:"幼圆";
	color:red;
}
.more{
	width:20%;;
	height:100px;
	line-height:100px;
	text-align:center;
	font-family: "华文彩云";
	font-size:36px;
	float:left;
	margin-left:5%;
	margin-top:5%;
	background:#0CF}
	.big{
	width:100%;
	height:100%;
	float:left;
	background:#FC0;}
</style>
</head>
<body>
<%List<Goods> Allgoods=(List<Goods>)session.getAttribute("Allgoods");
%>
<div class="big" >
<div class="">欢迎使用网上商场系统，这里是首页。</div>
<div class="rm">热门商品：</div>
<%if(Allgoods!=null){
    	 for(int i=0;i<Allgoods.size();i++){
    		 if(Allgoods.get(i).getIspreferred()==0){
    %>
     <div class="sp">
       <div align="center"><a href="goodsinfo.jsp?id=<%=i%>" ><img src="../images/<%=Allgoods.get(i).getGoods_pic()%>" width="77%" height="245"></a>
       </div>
       <div align="center"><a href="goodsinfo.jsp?id=<%=i%>" ><%=Allgoods.get(i).getGoods_name()%></a></div>
   <div align="center"><%=Allgoods.get(i).getGoods_price()%></div>
</div>
      <div align="center">
        <%}
    		 }
    	 }%>
   	</div>
</div>
</body>
</html>