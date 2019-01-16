<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../back_common/taglib.jsp" %>

              <!-- BEGIN EXAMPLE TABLE PORTLET-->
                     <div class="portlet-body">
							<div class="table-toolbar table-responsive">
								<div class="btn-group">
									 <button id="adminManagement_addBtn" class="btn green">
									添加管理员<i class="fa fa-plus"></i>
									</button>
								</div>
								<%-- <jsp:include page="../../common/commonTools.jsp"></jsp:include> --%>
							</div>
							<!-- <div class="row search-form-default">
									<div class="col-md-12">
										<form class="form-inline" action="#">
											<div class="input-group">
												<div class="input-cont">
													<input type="text" placeholder="Search..." class="form-control"/>
												</div>
												<span class="input-group-btn">
													<button type="button" class="btn green">
													Search &nbsp; <i class="m-icon-swapright m-icon-white"></i>
													</button>
												</span>
											</div>
										</form>
									</div>
							</div> -->
							<table class="table table-striped table-bordered table-advance table-hover" id="adminManagementTable">
							<thead>
							<tr role="row" class="heading">
								<!--<th class="table-checkbox">
									<input type="checkbox" class="group-checkable" data-set="#adminManagement .checkboxes"/>
								</th>-->
								<th>用户名</th>
								<th>真实姓名</th>
								<th>操作</th>
							</tr>
							</thead>

							</table>
						</div>
					<!-- END EXAMPLE TABLE PORTLET-->