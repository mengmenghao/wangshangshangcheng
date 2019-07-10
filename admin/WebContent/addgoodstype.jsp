<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ziti {
	font-size: 36px;
	font-family: "华文中宋";
}
.zi {
	font-size: 22px;
}
.zi2 {
	font-size: 22px;
}
</style>
</head>
<body>
<form name="form1" method="post" action="GoodsTypeServlet">
  <div align="center" class="ziti">
    <p>添加类别</p>
    <p><span class="zi">类别名称</span>：
      <label for="textfield"></label>
      <input type="text" name="name" id="name">
    </p>
    <p><span class="zi2">类别详情</span>：
      <label for="textfield2"></label>
      <input type="text" name="desc" id="desc">
    </p>
    <p>
      <input type="submit" name="button" id="button" value="添加">
      <input type="reset" name="button2" id="button2" value="重置">
      <input type="button" name="button" id="button" value="返回" onclick="fanhui()">
    </p>
  </div>
</form>
<script type="text/javascript">
function fanhui(){
	history.go(-1);
}
</script>
</body>
</html>