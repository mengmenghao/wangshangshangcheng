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

	.big{
	width:100%;
	height:100%;
	float:left;
	background:#FC0;}
</style>
</head>
<body>
<%String typeid=request.getParameter("id"); 
int id=Integer.parseInt(typeid);
List<Goods> Allgoods=(List<Goods>)session.getAttribute("Allgoods");
%>

<div class="big">
  <div align="center">
    <table  border="1" >
      <div align="center">
        <%if(Allgoods!=null){
    	 for(int i=0;i<Allgoods.size();i++){
    		 if(id==Allgoods.get(i).getType_id()){
    %>
      </div>
     <div class="sp"><a href="goodsinfo.jsp?id=<%=i%>" ><img src="../images/<%=Allgoods.get(i).getGoods_pic()%>" width="77%" height="245"></a>
  <div align="center"><a href="goodsinfo.jsp?id=<%=i%>" ><%=Allgoods.get(i).getGoods_name()%></a></div>
   <div align="center"><%=Allgoods.get(i).getGoods_price()%></div>
</div>
      </tr> 
      <div align="center">
        <%}
    		 }
    	 }%>
        </div>
      </table>
  </div>
    	 </div>
</body>
</html>