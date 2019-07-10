<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.List,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<%List<shopcar> shopcar=(List<shopcar>)session.getAttribute("shopcar");
Orders sum=(Orders)session.getAttribute("sum");
%>
<div class="big">
  <div align="center">
    <table  border="1" >
    <tr>
      <td width="103" class="cloor">图片</td>
      <td width="110" class="cloor">商品名字</td>
      <td width="103" class="cloor">单价</td>
      <td width="150" class="cloor">数量</td>
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
        <td width="150" class="cloor"><div align="left"><%=shopcar.get(i).getNum() %></td>
        <%}
    	 }%>
   </table>
   </div>
    <div align="center">
      总价：<%=sum.getOrderSum()%>
    </div>
   </div>
<form name="form1" method="post" action="../orderfinServlet">
  <div align="center">
    <table width="760" border="1">
      <tr>
        <td colspan="4" bgcolor="#FFCC66">请完善信息</td>
      </tr>
      <tr>
        <td width="71" bgcolor="#FFCC66">收货人</td>
        <td width="389"><label for="newTitle_1"></label><input name="contactman" type="text" id="contactman" size="50" value=""></td>
        <td width="94" bgcolor="#FFCC66">邮政编码</td>
        <td width="178"><input name="postcode" type="text" id="postcode" size="20" value=""></td>
      </tr>
      <tr>
        <td bgcolor="#FFCC66">收货地址</td>
        <td width="389"><label for="newTitle_1"></label><input name="address" type="text" id="address" size="50" value=""></td>
      <tr>
        <td colspan="4" bgcolor="#FFCC66"><div align="center">备注</div></td>
      </tr>
      <tr>
        <td height="167" colspan="4"><div align="center">
          <textarea name="note" cols="50" rows="10" id="note"></textarea>
        </div></td>
      </tr>
    </table>
    <table width="757" border="1">
      <tr>
        <td width="745" colspan="4" bgcolor="#FFCC66"><div align="center">
          <input type="submit" name="xg" id="xg" value="提交" >
        </div></td>
      </tr>
    </table>
  </div>
</form>
<form name="form1" method="post" action="../deleteorderServlet">
  <div align="center">
    <input type="submit" name="fh" id="fh" value="返回" onclick="re()">
  </div>
</form>
<script type="text/javascript">
function check(){
	 var contactman=document.getElementById("contactman").value;
	 var address=document.getElementById("address").value;
	 var postcode=document.getElementById("postcode").value;
	 if(contactman.length==0){
		 alert("请输入收货人");
	 }
	 else if(address.length==0){
		 alert("请输入收货地址");
	 }
	 else if(postcode.length==0){
		 alert("请输入邮政编码");
	 }
	 else {
		 form1.submit();
	 }
}

</script>
</body>
</html>