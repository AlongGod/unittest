<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>

<div class="note note-success">
	<h4 class="block"></h4>
	<p>
		 您好，该功能未开通，请联系管理员
		<a href="${ctx}/admin/index" >
			 点击这里返回首页
		</a>
		 .
	</p>
</div>
