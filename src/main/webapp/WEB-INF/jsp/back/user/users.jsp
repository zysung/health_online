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
  		<c:if test="${page.getTotal() le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${page.getTotal() gt 0}" >
  			<c:forEach items="${page.list}" var="user" varStatus="status">
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
			<td colspan="12" align="right">
				<ul class="pagination pagination-sm">
					<li><a>共 ${page.total } 条记录</a></li>
					<li><a>共 ${page.pages} 页</a></li>
					<li><a>当前第 ${page.pageNum  } 页</a></li>
					<li><a href="?condition=${condition}&&page=1">首页</a></li>
					<c:if test="${page.pageNum!= 1 }">
						<li><a href="?condition=${condition}&&page=${page.pageNum -1}">上一页</a></li>
					</c:if>
					<c:if test="${page.pageNum < page.pages }">
						<li><a href="?condition=${condition}&&page=${page.pageNum +1}">下一页</a></li>
					</c:if>
					<li><a href="?condition=${condition}&&page=${page.pages}">尾页</a></li>
				</ul>
				<td/>
			</tr>
  		</c:if>
  	</table>
  </body>
  
</html>
