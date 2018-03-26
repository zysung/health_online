<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>医院详细信息</title>
	

  </head>
  
  <body>
	<ul class="list-unstyled" style="font-size: 300%;">
		<li>医院标志：
		<c:choose> 
			<c:when test="${hospital.logo ne null }"><img src="logo" width="70" height="70" class="img-rounded "/></c:when>
			<c:otherwise>该医院暂未上传图片</c:otherwise>
		</c:choose>
		</li>
		<li>医院名：${hospital.name }</li>
	  	<li>医院级别：${hospital.level }</li>
	  	<li>医院专长：${hospital.expertise}</li>
	  	<li>邮箱地址：${hospital.description}</li>
		<li>医院评分：${hospital.marks }</li>
	    <li>医院地址：${hospital.address }</li>
		<li>联系电话：	${hospital.phone1 }
		 					<c:if test="${hospital.phone2 ne null}">，${hospital.phone2 }</c:if>
		 					<c:if test="${hospital.phone3 ne null}">${hospital.phone3 }</c:if>
		 </li>
		<li>医院简介：<c:choose> 
								<c:when test="${hospital.decription ne null}">${hospital.decription }</c:when>
			 					<c:otherwise>该医院暂无简介</c:otherwise>
		 					</c:choose> 
		</li>
	 </ul>
  </body>
</html>
