<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Type,com.cn.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#xq {
	font-family: "华文琥珀";
	font-weight: bold;
}
#button {
	font-weight: bold;
	font-family: "华文琥珀";
}
.neirong {
	font-family: "华文琥珀";
}
.time {
	font-family: "华文琥珀";
}
.headline {
	font-family: "华文琥珀";
}
.bt {
	font-family: "方正舒体";
}
.sj {
	font-family: "方正舒体";
}
.mainbody {
	font-family: "方正舒体";
}
</style>
</head>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<%
Type type=(Type)session.getAttribute("type");
%>
<form name="form1" method="post" action="ViewDetailsServlet">
  <table width="425" border="1" align="center">
    <tr>
      <th colspan="2" align="center" valign="middle" bgcolor="#99FFFF" scope="row" id="xq">详情</th>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">类别编号</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=type.getType_id() %></td>
    </tr>
    <tr>
      <th width="123" bgcolor="#99FFFF" class="headline" scope="row">类别名</th>
      <td width="286" bgcolor="#FFFFFF" class="bt"><%=type.getType_name() %></td>
    </tr>
    <tr>
      <th height="220" bgcolor="#99FFFF" class="neirong" scope="row">类别详情</th>
      <td bgcolor="#FFFFFF" class="mainbody"><%=type.getType_desc()%></td>
    </tr>
    <tr>
      <th colspan="2" bgcolor="#00FFFF" scope="row"><input type="button" name="button" id="button" value="返回" onclick="fanhui()"></th>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
<script type="text/javascript">
function fanhui(){
	history.go(-1);
}
</script>
</body>
</html>