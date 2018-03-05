<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户${user.account }的所有运动数据列表</title>
	
  </head>
  
  <body>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>序号</td>
  			<td>用户账号</td>
  			<td>记录时间</td>
  			<td>步数</td>  			
  			<td>行走公里数</td>
  			<td>浅度睡眠时间(小时)</td>
  			<td>深度睡眠时间(小时)</td>
  		</tr>
  		<c:if test="${pager.total le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${pager.total gt 0}" >
  			<c:forEach items="${pager.datas}" var="sportdata" varStatus="status">			
  				<tr>
  					<td>${status.index+1 }</td>
  					<td>${sportdata.userAccount }</td>
  					<td><fmt:formatDate value="${sportdata.collectionTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td><!--输出在当页的序号  -->
  					<td>${sportdata.step}</td>
  					<td>${sportdata.kilometers }</td>
  					<td>${sportdata.lightSleep }</td>
  					<td>${sportdata.deepSleep}</td>
  				</tr>
  			</c:forEach>
 			<tr>
				<td colspan="10" align="right">
					<jsp:include page="/inc/pager.jsp">
						<jsp:param value="usersportdatas" name="url"/>
						<jsp:param value="${pager.total}" name="items"/>
					</jsp:include>
				</td>
			</tr>	
  		</c:if>
  	</table>
  </body>
  
</html>
