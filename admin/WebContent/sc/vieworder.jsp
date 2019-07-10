<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.OrdersDetail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<OrdersDetail> userlist=(List<OrdersDetail>)session.getAttribute("or"); %>
<form name="form1" method="post" action="SelectUserServlet">
<div align="center">
    <table  border="1" >
      <tr bgcolor="#FFFFFF" class="bt">
        <td width="103" align="center" valign="middle" class="cloor">序号</td>
        <td width="103" align="center" class="cloor">订单号</td>
        <td width="93" align="center" class="cloor">商品编号</td>
        <td width="93" align="center" class="cloor">商品名称</td>
        <td width="103" align="center" class="cloor">商品图片</td>
        <td width="103" align="center" class="cloor">商品单价</td>
        <td width="103" align="center" class="cloor">商品数量</td>
        <td width="103" align="center" class="cloor">商品总价</td>
      </tr>
       <%if(userlist!=null){
    	 for(int i=0;i<userlist.size();i++){
    %>
      <tr align="center" valign="middle">
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=i+1 %></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getOrder_id()%></td>
        <td width="93" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getGoods_id()%></td>
		<td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getGoods_name()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><img src="../images/<%=userlist.get(i).getGoods_pic()%>" width="50"></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getGoods_price()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getQty()%></td>
        <td width="103" bgcolor="#FFFFFF" class="cloor"><%=userlist.get(i).getGoods_price()*userlist.get(i).getQty()%></td>
    		 <%  
	      }
    	  } 
    	  
    	 %> 
    </table>
 </div>
 </form>
 <div align="center">
    <input type="button" name="fh" id="fh" value="返回" onclick="fanhui()">
  </div>
  <script type="text/javascript">
function fanhui(){
	history.go(-1);
}
</script> 
</body>
</html>