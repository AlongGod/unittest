<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- add "navbar-no-scroll" class to disable the scrolling of the sidebar menu -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
				<li class="sidebar-toggler-wrapper tooltips" data-container="body" data-placement="right" data-html="true" data-original-title="折叠/展开左侧菜单栏">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone">
					</div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li class="sidebar-search-wrapper">
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					 <form class="sidebar-search" action="#" method="POST">
						<div class="form-container">
							<!-- <div class="input-box">
								<a href="javascript:;" class="remove">
								</a>
								<input type="text" placeholder="搜索..."/>
								<input type="button" class="submit" value=" "/>
							</div> -->
						</div>
					</form> 
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>
				<li id="businessModuleManagementMenu">
					<a href="javascript:;">
						<span class="title">
						<i class="fa fa-table"></i>
							业务模块管理
						</span>
						<span class="arrow ">
						</span>
					</a>
					<ul class="sub-menu">
						    <li id="expectresultManageMenu">
								<a href="${ctx}/backendexpectresult/expectresultManagement"><i class="fa fa-th"></i>
									expectresult管理
								</a>
							</li>
						    <li id="testcaseManageMenu">
								<a href="${ctx}/backendtestcase/testcaseManagement"><i class="fa fa-th"></i>
									testcase管理
								</a>
							</li>
					</ul>
				</li>
				<li id="systemSettingMenu">
					<a href="javascript:;">
						<span class="title">
						<i class="fa fa-cogs"></i>
							系统管理
						</span>
						<span class="arrow ">
						</span>
					</a>
					<ul class="sub-menu">
						<li id="adminManageMenu">
							<a href="${ctx}/backendadmin/adminManagement"><i class="fa fa-user-md"></i>
								管理员管理
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
<script type="text/javascript">
	var globalAdminType = ${loginAdmin.adminType}
</script>
