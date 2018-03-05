<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager maxPageItems="6"  items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<c:forEach items="${param.params }" var="p">
	<pg:param name="${p }"/>
</c:forEach>
<pg:last>
共${param.items }个记录,共${pageNumber }页,
</pg:last>
当前第${curPage }页
<pg:first>
	<a href="${param.url }pager.offset=0">首页</a>
</pg:first>
<pg:prev>
	<a href="${param.url}pager.offset=${(curPage-2)*6 }">上一页</a>
</pg:prev>
<pg:pages>
<c:if test="${curPage eq pageNumber}">
	[${pageNumber }]
</c:if>
<c:if test="${curPage ne pageNumber }">
	<a href="${param.url }pager.offset=${(pageNumber-1)*6}">${pageNumber }</a>
</c:if>
</pg:pages>
<pg:next>
	<a href="${param.url }pager.offset=${curPage*6}">下一页</a>
</pg:next>
<pg:last>
	<a href="${param.url}pager.offset=${(pageNumber-1)*6}">尾页</a>
</pg:last>
</pg:pager>