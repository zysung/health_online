<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 日期格式标签库 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户所有监护数据列表</title>
	
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
  		<c:if test="${page.getTotal() le 0 }">
  			<tr>
  				<td colspan="10">目前没有用户数据</td>
  			</tr>
  		</c:if>
  		<c:if test="${page.getTotal() gt 0}" >
  			<c:forEach items="${page.list}" var="custodydata" varStatus="status">
  				<tr>
  					<td><fmt:formatDate value="${custodydata.collectionTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td><!--输出在当页的序号  -->
  					<td>${custodydata.heartRate}</td>
  					<td>${custodydata.systolicPressure }</td>
  					<td>${custodydata.diastolicPressur }</td>
  					<td>${custodydata.temperature}</td>
  					<td>${custodydata.bloodOxygen}</td>
  					<td>${custodydata.uvIndex}</td>
  					<td><a href="<%=request.getContextPath() %>/back/data/${user.account}/latestcustodydata" >查看最新监护数据</a></td>
  				</tr>
  			</c:forEach>
 			<tr>
				<td colspan="12" align="right">
					<ul class="pagination pagination-sm">
						<li><a>共 ${page.total } 条记录</a></li>
						<li><a>共 ${page.pages} 页</a></li>
						<li><a>当前第 ${page.pageNum  } 页</a></li>
						<li><a href="?page=1">首页</a></li>
						<c:if test="${page.pageNum!= 1 }">
							<li><a href="?page=${page.pageNum -1}">上一页</a></li>
						</c:if>
						<c:if test="${page.pageNum < page.pages }">
							<li><a href="?page=${page.pageNum +1}">下一页</a></li>
						</c:if>
						<li><a href="?page=${page.pages}">尾页</a></li>
					</ul>
				<td/>
			</tr>	
  		</c:if>
  	</table>
  </body>
  
</html>
