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
<form name="form1" method="post" action="../updateuserinfoSverlet">
  <div align="center">
  <input name="pass" type="hidden" id="pass" size="60" value="<%=u.getpass()%>" >
  <input name="id" type="hidden" id="id" size="60" value="<%=u.getid()%>" >
    <table width="744" border="1">
      <tr>
        <td colspan="4" bgcolor="#FFFF00">个人资料</td>
      </tr>
      <tr>
        <td width="95" bgcolor="#FFFF99">姓名</td>
        <td width="223"><label for="newTitle_1"></label><input name="name" type="text" id="name" size="50" value="<%=u.getname()%>"></td>
        <td width="106" bgcolor="#FFFF66">性别</td>
        <td width="292"><label for="newTitle_2"><input type="radio" name="sex" id="sex" value="男">男
  		<input type="radio" name="sex"  id="sex" value="女">女
  		</label></td>
      </tr>
      <tr>
        <td bgcolor="#FFFF99">电子邮件</td>
        <td width="223"><label for="newTitle_1"></label><input name="email" type="text" id="email" size="50" value="<%=u.getEmail()%>"></td>
        <td bgcolor="#FFFF66">爱好</td>
        <td><input type="checkbox" name="hobb" id="hobb" value="游戏">游戏
  <input type="checkbox" name="hobb" id="hobb" value="读书">读书
  <input type="checkbox" name="hobb" id="hobb" value="运动">运动
  <input type="checkbox" name="hobb" id="hobb" value="其他">其他</td>
      </tr>
      <tr>
        <td bgcolor="#FFFF99">真实姓名</td>
        <td width="223"><label for="newTitle_1"></label><input name="rname" type="text" id="rname" size="50" value="<%=u.getRname()%>"></td>
        <td bgcolor="#FFFF66">联系电话</td>
        <td width="223"><label for="newTitle_1"></label><input name="phone" type="text" id="phone" size="50" value="<%=u.getPhone()%>"></td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#FFFF00"><div align="center">个人介绍/备注</div></td>
      </tr>
      <tr>
        <td height="167" colspan="4"><div align="center">
          <textarea name="introduce" cols="50" rows="10" id="introduce"><%=u.getIntroduce() %></textarea>
        </div></td>
      </tr>
    </table>
    <table width="744" border="1">
      <tr>
        <td width="770" colspan="4" bgcolor="#FFFFFF"><div align="center">
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