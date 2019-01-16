<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>
<!-- 进度条 -->
<script src="${ctx}/assets/plugins/pace/pace.min.js" type="text/javascript"></script>
<!-- 样式1 -->
<link href="${ctx}/assets/plugins/pace/themes/pace-theme-flash.css" rel="stylesheet" type="text/css"/>
<!-- 样式2 -->
<%-- <link href="${ctx}/assets/plugins/pace/themes/pace-theme-barber-shop.css" rel="stylesheet" type="text/css"/> --%>