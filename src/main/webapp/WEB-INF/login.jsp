<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<form id="itemForm" action="http://localhost:8080/health_online/login" method="get" enctype="multipart/form-data">
    <table width="100%" border=1>
        <tr>
            <td>
                account:<input type="text" name="account" value="lepus"/><br>
                password:<input type="text" name=password value="1234"/><br>
                <input type="submit" value="提交"/><br>
            </td>
        </tr>
    </table>
</form>
</body>
</html>