<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>custodyDataUpdate.jsp</title>
</head>
<body>
<form id="itemForm" action="http://localhost:8080/health_online/custodyDataUpdate" method="post" enctype="multipart/form-data">
<table width="100%" border=1>
<tr>
<td>
userAccount:<input type="text" name="userAccount" value="lepus"/><br>
heartRate:<input type="text" name="heartRate" value="2"/><br>
systolicPressure:<input type="text" name=systolicPressure value="12"/><br>
diastolicPressur:<input type="text" name="diastolicPressur" value="15"/><br>
temperature:<input type="text" name="temperature" value="12.2"/><br>
bloodOxygen:<input type="text" name="bloodOxygen" value="12.23"/><br>
uvIndex:<input type="text" name="uvIndex" value="12"/><br>
<input type="submit" value="提交"/><br>
</td>
</tr>
</table>
</form>
</body>
</html>