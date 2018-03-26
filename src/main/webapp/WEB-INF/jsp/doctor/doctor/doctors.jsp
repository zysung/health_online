<%@page import="cn.edu.gdin.po.Hospital"%>
<%@page import="cn.edu.gdin.po.Doctor"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>医生资料列表</title>
	
  </head>
  
  <body>
  	<form action="doctors"  method="get"  class="form-inline">
  		<input type="text" name="condition" placeholder="医生姓名、专长或所在医院" class="form-control" value="${condition }" style="width:20%;">
  		<input type="submit" value="查找" class="form-control btn-primary btn-sm" style="background:#1cb394;border:0;">
  	</form>
  	<table class="table"  style="font-size:10px;margin-top:10px;">
  		<tr>
  			<td>序号</td>
  			<td>姓名</td>
  			<td>性别</td>
  			<td>职称</td>
  			<td>评价</td>
  			<td>科室</td>
  			<td>执业点</td>
  			<td>电话</td>
  			<td>操作</td>
  			
  		</tr>
  		<c:if test="${pager.total le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${pager.total gt 0}" >
  			<c:forEach items="${pager.datas }" var="doctor" varStatus="status">			
  				<tr>
  					<td>${status.index+1 }</td><!--输出在当页的序号  -->
  					<td>${doctor.name}</td>
  					<td>${doctor.sex }</td>
  					<td>${doctor.title }</td>
  					<td>${doctor.marks }</td>
  					<td>${doctor.expertise }</td>
  					<td>${doctor.hospital.name}</td>
  					<td>${doctor.phone }</td>
  					<td>
  					<a href="${doctor.id}/show">详情</a>&nbsp;
  					<%--<a href="${doctor.id}/update">修改</a>&nbsp;--%>
  					<%--<a href="${doctor.id}/delete" onclick=" return confirm('该医院所有资料将被删除！是否继续')">删除</a>--%>
  					</td>
  				</tr>
  			</c:forEach>
 			<tr>
 				<td colspan="3">
 				<%--<button onclick="location.href='<%=request.getContextPath() %>/back/doctor/add'" class="btn btn-primary pull-left"style="background:#1cb394;border:0;">添加医生数据</button>--%>
 				</td>
				<td colspan="7" align="right">
					<jsp:include page="/inc/pager.jsp">
						<jsp:param value="doctors?condition=${condition}&&" name="url"/>
						<jsp:param value="${pager.total}" name="items"/>
					</jsp:include>
				</td>
			</tr>	
  		</c:if>
  	</table>
  </body>
  
</html>
