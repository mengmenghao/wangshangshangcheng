<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.User2"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin:0px;padding:0px;}
.big{ width:100%;
height:85px;
background:#F90;}
.title{
	float:left;
	width:30%;
	}
.zt{
	font-size:24px;
	line-height:85px;
	text-align:center;}

.qx{
	float:none;}
	*{
	margin: 0;
	padding: 0;
}
ul,li{
	list-style:none;
}
.menu{
	float:left;
	width:70%;
	height:85px;
	background:#0F3A8F;
	
}
.menu_ul>li{
	float:left;
	width:15%;
	position:relative;  
}
.menu_ul>li>a{
	color:#fff;
	text-decoration:none;
	line-height:85px;
	text-align:center;
	display:block;
	width:125px;
	height:85px;
	}
.menu_ul>li>a:hover{
	background:#05065B;
	}
 
.menu_ul>li:hover>a{
	background:#05065B;
	}

</style>
</head>
<body>
<%User2 u=(User2)session.getAttribute("name");%>
<div class="big">
<div class="title">
<p class="zt">欢迎回来，<%=u.getname() %></p>
</div>
<div class="qx"></div><div class="menu">
	<ul class="menu_ul">
    	<li>
       	  <a href="content.jsp" target="content">首页</a>
        </li>
        <li>
       	  <a href="../typeselectServlet" target="content">商品分类</a>
            
        </li>
        <li>
        	<a href="myPage.jsp" target="content">个人首页</a>
           
        </li>
        <li >
        	<a href="shopcar.jsp" target="content">我的购物车</a>
           
        </li>
        <li >
        	<a href="../orderselectservlet?id=<%=u.getid()%>" target="content">我的订单</a>       
        </li>
        <li>
        	<a href="dl.jsp" target="_top">注销</a>
        </li>
	</ul>
</div>
</div>
<script type="text/javascript" src="script/jquery-3.2.1.min.js">
 </script>
<script type="text/javascript">
function typefind(){
	
}
 </script>
</body>
</html>