<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户最新监护记录</title>

  </head>
  
  <body>
  	<h3>用户账号:${user.account}</h3>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>记录时间</td>
  			<td>心率(PR/m)</td>  			
  			<td>收缩压(mmHg)</td>
  			<td>舒张压(mmHg)</td>
  			<td>体温(°C)</td>
  			<td>血氧含量(%)</td>
  			<td>紫外线指数(级)</td>
  			<td>操作</td>
  		</tr>
  		<c:choose>
  			<c:when test="${latestCustodyData eq NULL}">
  				<tr>
  				<td colspan="6">该用户尚未有监护数据</td>
  			</tr>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td><fmt:formatDate value="${latestCustodyData.collectionTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td><!--输出在当页的序号  -->
  					<td>${latestCustodyData.heartRate}</td>
  					<td>${latestCustodyData.systolicPressure }</td>
  					<td>${latestCustodyData.diastolicPressur }</td>
  					<td>${latestCustodyData.temperature}</td>
  					<td>${latestCustodyData.bloodOxygen}</td>
  					<td>${latestCustodyData.uvIndex}</td>
  					<td><a href="<%=request.getContextPath() %>/back/${user.account}/custodydatas" >查看所有运动数据</a></td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  			
  	</table>
  </body>
  
</html>
