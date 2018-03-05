<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sportdataUpdate</title>
</head>
<body>
<form id="itemForm" action="http://localhost:8080/health_online/sportdataUpdate" method="post" enctype="multipart/form-data">
<table width="100%" border=1>
<tr>
<td>
userAccount:<input type="text" name="userAccount" value="吴奋"/><br>
step:<input type="text" name=step value="1234"/><br>
kilometers:<input type="text" name="kilometers" value="1233"/><br>
lightSleep:<input type="text" name="lightSleep" value="214"/><br>
deepSleep:<input type="text" name="deepSleep" value="123"/><br>
<input type="submit" value="提交"/><br>
</td>
</tr>
</table>
</form>
</body>
</html>