<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>监护数据管理</title>
	
  </head>
  
  <body>
  	<form action="userstocustodydatas"  method="get"  class="form-inline">
  		<input type="text" name="condition" placeholder="请输入用户名关键字" class="form-control">
  		<input type="submit" value="查找" class="form-control btn-primary btn-sm" style="background:#1cb394;border:0;">
  	</form>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>序号</td>
  			<td>账号</td>
  			<td>姓名</td>  			
  			<td>操作</td>
  		</tr>
  		<c:if test="${pager.total le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${pager.total gt 0}" >
  			<c:forEach items="${pager.datas }" var="user" varStatus="status">			
  				<tr>
  					<td>${status.index+1 }</td><!--输出在当页的序号  -->
  					<td>${user.account }</td>
  					<td>${user.name }</td>
  					<td><a href="${user.account}/latestcustodydata">查看最新监护数据</a>
  						&nbsp;&nbsp;&nbsp;&nbsp;
  						<a href="${user.account}/custodydatas" >查看所有监护数据</a>
  					</td>
  				</tr>
  			</c:forEach>
 			<tr>
				<td colspan="10" align="right">
					<jsp:include page="/inc/pager.jsp">
						<jsp:param value="userstocustodydatas?condition=${condition}&&" name="url"/>
						<jsp:param value="${pager.total}" name="items"/>
					</jsp:include>
				</td>
			</tr>	
  		</c:if>
  	</table>
  </body>
  
</html>
