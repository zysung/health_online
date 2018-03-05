<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regist</title>
</head>
<body>
<form id="itemForm" action="http://localhost:8080/health_online/regist" method="post" enctype="multipart/form-data">
<table width="100%" border=1>
<tr>
<td>
account:<input type="text" name="account" value="吴奋"/><br>
password:<input type="text" name=password value="1234"/><br>
email:<input type="text" name="email" value="597354724@qq.com"/><br>
name:<input type="text" name="name" value="吴奋"/><br>
sex:<input type="text" name="sex" value="男"/><br>
phone:<input type="text" name="phone" value="12345678"/><br>
profession:<input type="text" name="profession" value="23158498的dvd"/><br>
address:<input type="text" name="address" value="广州"/><br>
birthday:<input type="text" name="birthday" value="2015-03-20 12:25:53"/><br>
Useravatar:<input type="file"  name="Useravatar"/> <br>
<input type="submit" value="提交"/><br>
</td>
</tr>
</table>
</form>
</body>
</html>