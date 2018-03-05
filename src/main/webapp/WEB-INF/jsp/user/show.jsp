<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>${user.account}的详细资料</title>
	

  </head>
  
  <body>
  <div class="container">
  		<div class="row">
        <div class="col-lg-4">
		<ul class="list-unstyled" style="font-size: 300%;">
			
			<li>用户名：${user.name}</li>
		  	<li>用户邮箱：${user.email }</li>
			<li>用户性别：${user.sex}</li>
		    <li>联系电话：${user.phone }</li>
			<li>生日：<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></li>
			<li>职业：${user.profession}</li>
			<li>联系地址：${user.address}</li>
		 </ul>
		 </div>
		 <div class="col-lg-4">
		 		<c:choose> 
				<c:when test="${user.avatar ne null }"><img src="avatar" width="150" height="150" class="img-rounded pull-right" style="r"/></c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		 </div>
	</div>
</div>
  </body>
</html>
