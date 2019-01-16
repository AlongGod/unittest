<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>

   <!-- BEGIN HEADER -->
<div class="header navbar navbar-fixed-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<!-- BEGIN LOGO -->
		<a class="navbar-brand" href="${ctx}/admin/index" style="font-family:Microsoft YaHei;padding-top:0;font-size:20px;margin-top:10px;color:#ffffff">
			&nbsp;&nbsp;<b>unittest管理后台</b>
		</a>
		<!-- END LOGO -->
		
				<!-- BEGIN HORIZANTAL MENU -->
		<div class="hor-menu hidden-sm hidden-xs">
			<ul class="nav navbar-nav">
				<li class="classic-menu-dropdown active">
					<a href="${ctx}/admin/index">
						首页工作台
						<span class="selected">
						</span>
					</a>
				</li>
				<!-- <li>
					<a href="#">
						 功能介绍
					</a>
				</li> -->
				<!-- <li>
					<a href="#" target="_blank">
						 使用指南
					</a>
				</li>
				<li class="classic-menu-dropdown">
					<a data-toggle="dropdown" data-hover="dropdown" data-close-others="true" href="">
						 帮助中心 <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="http://wpa.qq.com/msgrd?v=3&uin=315918687&site=qq&menu=yes" target="_blank">
								 在线客服
							</a>
						</li>
						<li>
							<a href="${ctx}/help/aboutus">
								 关于我们
							</a>
						</li>
						<li>
							<a href="#">
								 常见问题
							</a>
						</li>
					</ul>
				</li> -->
				<!-- <li>
					<span class="hor-menu-search-form-toggler">
						 &nbsp;
					</span>
					<div class="search-form">
						<form class="form-search">
							<div class="input-group">
								<input type="text" placeholder="搜索..." class="form-control">
								<div class="input-group-btn">
									<button type="button" class="btn"></button>
								</div>
							</div>
						</form>
					</div>
				</li> -->
			</ul>
		</div>
		<!-- END HORIZANTAL MENU -->
		
		
<jsp:include page="navigation.jsp"></jsp:include>
	</div>
	<!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->