<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;


String language = "{  " 
		+ "\"sProcessing\":   \"处理中...\", "
				+ "\"sLengthMenu\":   \"显示 _MENU_ 项结果\", "
				+ "\"sZeroRecords\":  \"没有匹配结果\", "
				+ "\"sInfo\":         \"显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项\", "
				+ "\"sInfoEmpty\":    \"显示第 0 至 0 项结果，共 0 项\", "
				+ "\"sInfoFiltered\": \"(由 _MAX_ 项结果过滤)\", "
				+ "\"sInfoPostFix\":  \"\", "
				+ "\"sSearch\":       \"搜索:\", "
				+ "	\"sUrl\":          \"\", "
				+ "	\"sEmptyTable\":     \"表中数据为空\", "
				+ "\"sLoadingRecords\": \"载入中...\", "
				+ "\"sInfoThousands\":  \",\", "
				+ "	\"oPaginate\": { "
				+ "    \"sFirst\":    \"首页\", "
				+ "    \"sPrevious\": \"上页\", "
				+ "    \"sNext\":     \"下页\", "
				+ "    \"sLast\":     \"末页\" "
				+ "}, "
				+ "\"oAria\": { "
				+ "    \"sSortAscending\":  \": 以升序排列此列\", "
				+ "    \"sSortDescending\": \": 以降序排列此列\" "
				+ "} "
				+ "}";  
%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>
