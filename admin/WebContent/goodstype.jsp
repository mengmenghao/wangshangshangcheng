<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.Type,java.util.*"%>
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
<body>
<%List<Type> typelist=(List<Type>)session.getAttribute("typelist");
	//UserService  userService=new UserService();
	//User u=(User)session.getAttribute("user");
%>
<form name="form1" method="post">
  <p align="center">
  	<strong>
   	 <input type="button" name="button" id="button" onclick="addgoodstype()" value="添加商品类别">
  	</strong> 
    <input type="text" id="querynews" name="query" width="250px" height="30px"> 
    <input type="checkbox" name="checkbox" id="checkbox" value="0">
    <label for="checkbox" class="z">
     类别编号
    </label>
    <input type="checkbox" name="checkbox" id="checkbox2" value="1">
    <label for="checkbox2" class="z2">
    商品类别
    </label>
	<input type="checkbox" name="checkbox" id="checkbox3" value="2">
	<label for="checkbox3" class="z3">
    类别描述
    </label>

<input type="submit" value="查询" class="bu" onclick="QueryNews()">
  </p>
  <div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" class="cloor">商品类别编号</td>
        <td width="203" align="center" class="cloor">商品类别名称</td>
        <td width="93" align="center" class="cloor">商品类别描述</td>
        <td width="103" align="center" class="cloor">操作</td>
      </tr>
      <%if(typelist!=null){
    	 for(int i=0;i<typelist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=typelist.get(i).getType_id() %></td>
        <td width="203" bgcolor="#FFFFFF" class="cloor"><%=typelist.get(i).getType_name()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=typelist.get(i).getType_desc() %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor">
          <a href="updatetype.jsp?id=<%=i%>">修改</a>
          <a href="DeleteTypeServlet?id=<%=typelist.get(i).getType_id()%>">删除</a>
          <a href="ViewDetailsTypeServlet?id=<%=typelist.get(i).getType_id() %>">查看详情</a>
</td>
      </tr>
      <% }
    	 } 
    	 %>
    </table>
  </div>
</form>
<script type="text/javascript">
function addgoodstype(){
	window.location.href="addgoodstype.jsp";
}
function QueryNews(){
	form1.action="QueryTypeServlet";
	form1.submit();
}
</script>
</body>
</html>