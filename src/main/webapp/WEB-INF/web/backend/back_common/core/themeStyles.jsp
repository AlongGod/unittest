<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>

<link href="${ctx}/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<!-- plugins.css 影响ck的css ,但如果没有它进度条不起作用-->
<link href="${ctx}/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="${ctx}/assets/css/pages/search.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/assets/css/custom.css" rel="stylesheet" type="text/css"/>