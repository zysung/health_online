<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>医院资料列表</title>
  </head>
  
  <body>
	 <%
	 if ((String)session.getAttribute("msg") == "true") {
	 %>
	 <script>
	 	alert("操作成功！");
	 </script>
	 <%
	 	session.removeAttribute("msg");
	 }
	 %>
  	<form action="hospitals"  method="get"  class="form-inline">
  		<input type="text" name="condition" placeholder="医院名、等级或地址" class="form-control" value="${condition }">
  		<input type="submit" value="查找" class="form-control btn-primary btn-sm" style="background:#1cb394;border:0;">
  	</form>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>序号</td>
  			<td>医院名</td>
  			<td>级别</td>
  			<td>专长</td>
  			<td>评分</td>
  			<td>地址</td>
  			<td>邮箱</td>
  			<td>电话</td>
  			<td>操作</td>
  			
  		</tr>
  		<c:if test="${pager.total le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${pager.total gt 0}" >
  			<c:forEach items="${pager.datas }" var="hospital" varStatus="status">			
  				<tr>
  					<td>${status.index+1 }</td><!--输出在当页的序号  -->
  					<td>${hospital.name }</td>
  					<td>${hospital.level }</td>
  					<td >${hospital.expertise }</td>
  					<td>${hospital.marks }</td>
  					<td>${hospital.address }</td>
  					<td>${hospital.email }</td>
  					<td>${hospital.phone1 }</td>
  					<td>
  					<a href="${hospital.id}/show">详情</a>&nbsp;
  					<%--<a href="${hospital.id}/update">修改</a>&nbsp;--%>
  					<%--<a href="${hospital.id}/delete" onclick=" return confirm('该医院所有资料将被删除！是否继续')">删除</a>--%>
  					</td>
  				</tr>
  			</c:forEach>
 			<tr>
 				<td colspan="3">
 				<%--<button onclick="location.href='<%=request.getContextPath() %>/user/hospital/add'" class="btn btn-primary pull-left"style="background:#1cb394;border:0;">添加医院数据</button>--%>
 				</td>
				<td colspan="7" align="right">
					<jsp:include page="/inc/pager.jsp">
						<jsp:param value="hospitals?condition=${condition}&&" name="url"/>
						<jsp:param value="${pager.total}" name="items"/>
					</jsp:include>
				</td>
			</tr>	
  		</c:if>
  	</table>
  	
  </body>
  
</html>
