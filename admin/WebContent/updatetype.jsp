<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.cn.vo.Type"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<body background="image/a3bbedd47cac817f3580f3b24b365ceb806f46b9.jpg@1320w_742h.webp.jpg">
<div align="center">
 <%String id=request.getParameter("id");
List<Type> typelist=(List<Type>)session.getAttribute("typelist");
int i=Integer.parseInt(id);
Type t=typelist.get(i);
%>
</div>
<form name="form1" method="post" action="UpdateTypeServlet" id="form1">
  <div align="center">
    <input name="id" type="hidden" id="id" size="60" value="<%=t.getType_id()%>" >
    <table width="531" border="1" background="image/image_02.jpg">
      <tr>
        <td colspan="2" bgcolor="#66CC00">修改类别</td>
      </tr>
      <tr>
        <td width="89">类别名</td>
        <td width="426"><label for="newsTitle02"></label>
        <input name="name" type="text" id="name" size="60" value="<%=t.getType_name()%>"></td>
      </tr>
      <tr>
        <td>类别详情</td>
        <td><label for="zw_01"></label>
        <textarea name="desc" cols="50" rows="10" id="desc"><%=t.getType_desc() %></textarea></td>
      </tr>
      <tr>
        <td colspan="2">
          <div align="center">
            <input type="submit"  value="提交" onclick="checkType()">
            <input type="reset"   value="重置">
            <input type="button"   value="返回" onclick="re()">
          </div>
        </td>
      </tr>
    </table>
  </div>
</form>
</body>
<script type="text/javascript">
function checkType(){
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var desc=document.getElementById("descc").value;
	var f=document.getElementById("form1");
	if(name==""){
		alert("类别名不能为空");
		return;
	}
	if(desc==""){
		alert("请填写类别信息");
		return;
	}
	document.getElementById("form1").submit();
	
}
	
function re(){
	history.go(-1);
}
</script>
</html>