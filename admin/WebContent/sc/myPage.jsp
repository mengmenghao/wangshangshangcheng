<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%User2 u=(User2)session.getAttribute("name"); %>
<form name="form1" method="post" action="updateuserinfo.jsp">
  <div align="center">
    <table width="744" border="1">
      <tr>
        <td colspan="4" bgcolor="#FFFF00">个人资料</td>
      </tr>
      <tr>
        <td width="95" bgcolor="#FFFF99">姓名</td>
        <td width="223"><label for="newTitle_1"><%=u.getname()%></label></td>
        <td width="106" bgcolor="#FFFF66">性别</td>
        <td width="292"><%=u.getSex() %></td>
      </tr>
      <tr>
        <td bgcolor="#FFFF99">电子邮件</td>
        <td><label for="newTitle_2"><%=u.getEmail() %></label></td>
        <td bgcolor="#FFFF66">爱好</td>
        <td><%=u.gethobbies() %></td>
      </tr>
      <tr>
        <td bgcolor="#FFFF99">真实姓名</td>
        <td><label for="newTitle_2"><%=u.getRname() %></label></td>
        <td bgcolor="#FFFF66">联系电话</td>
        <td><%=u.getPhone() %></td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#FFFF00"><div align="center">个人介绍/备注</div></td>
      </tr>
      <tr>
        <td height="167" colspan="4"><%=u.getIntroduce() %></td>
      </tr>
    </table>
    <table width="744" border="1">
      <tr>
        <td colspan="4" bgcolor="#FFFFFF"><div align="center">
          <input type="submit" name="xg" id="xg" value="修改">
          <input type="button" name="fh" id="fh" value="返回" onclick="re()">
        </div></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </div>
</form>
<script type="text/javascript">

function re(){
	history.go(-1);
}

</script>
</body>
</html>