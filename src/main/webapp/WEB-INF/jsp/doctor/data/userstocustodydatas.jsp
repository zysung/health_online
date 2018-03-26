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
  		<c:if test="${page.getTotal() le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
		<c:if test="${page.getTotal() gt 0}" >
			<c:forEach items="${page.list}" var="user" varStatus="status">
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
