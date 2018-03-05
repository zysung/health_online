<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户资料列表</title>
	
  </head>
  
  <body>
  	<form action="users"  method="get"  class="form-inline">
  		<input type="text" name="condition" placeholder="请输入用户名关键字" class="form-control" value="${condition }">
  		<input type="submit" value="查找" class="form-control btn-primary btn-sm" style="background:#1cb394;border:0;">
  	</form>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>序号</td>
  			<td>头像</td>
  			<td>账号</td>
  			<td>邮箱</td>
  			<td>姓名</td>
  			<td>性别</td>
  			<td>电话</td>
  			<td>生日</td>
  			<td>职业</td>
  			<td>地址</td>
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
  					<td>
  					<c:choose>
  					<c:when test="${user.avatar ne null }">
  						<img alt="tt" src="${user.account}/avatar" width="50" height="50" class="img-rounded ">
  					</c:when>
  					<c:otherwise>
  						暂无头像
  					</c:otherwise>
  					</c:choose>
  					</td>
  					<td>${user.account }</td>
  					<td>${user.email }</td>
  					<td>${user.name }</td>
  					<td>${user.sex }</td>
  					<td>${user.phone }</td>
  					<td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
  					<td>${user.profession }</td>
  					<td>${user.address }</td>
  					
  					<td>
  					<a href="${user.account}/show">详情</a>&nbsp;
  					<a href="${user.account}/deleteUser" 
  					onclick=" return confirm('该用户所有资料将被删除！是否继续')">删除用户</a>
  					&nbsp;<a href="${user.account}/sendMessage" >发送系统消息</a></td>
  				</tr>
  			</c:forEach>
 			<tr>
				<td colspan="11" align="right">
					<jsp:include page="/inc/pager.jsp">
						<jsp:param value="users?condition=${condition}&&" name="url"/>
						<jsp:param value="${pager.total}" name="items"/>
					</jsp:include>
				</td>
			</tr>
  		</c:if>
  	</table>
  </body>
  
</html>
