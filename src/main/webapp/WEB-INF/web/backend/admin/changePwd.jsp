<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../back_common/taglib.jsp" %>
<!DOCTYPE html>
<jsp:include page="../back_common/ieCompatibility.jsp"></jsp:include>
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>修改密码</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>

<!-- BEGIN PACE PLUGIN FILES -->
<jsp:include page="../back_common/core/pacePluginFiles.jsp"></jsp:include>
<!-- END PACE PLUGIN FILES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<jsp:include page="../back_common/core/globalMandatoryStyles.jsp"></jsp:include>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/select2/select2-metronic.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/bootstrap-fileinput/bootstrap-fileinput.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/jquery-tags-input/jquery.tagsinput.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/typeahead/typeahead.css">
<!-- END PAGE LEVEL STYLES -->

<!-- BEGIN THEME STYLES -->
<jsp:include page="../back_common/core/themeStyles.jsp"></jsp:include>
<!-- END THEME STYLES -->

<!-- 上传文件 -->
<link rel="stylesheet" type="text/css" href="${ctx}/kindeditor/themes/default/default.css">

</head>

<style type="text/css" class="init">
/* body{
	width: 100%;
	height: 100%;
} */

	
</style>

<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-fixed">
<!-- BEGIN HEADER -->
   <jsp:include page="../back_common/bodyHeader.jsp"></jsp:include>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
  <!-- BEGIN CONTAINER -->
 <div class="page-container">
	<!-- BEGIN SIDEBAR -->
     <jsp:include page="../back_common/sidebar.jsp"></jsp:include>
     
     <!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<jsp:include page="../back_common/commonAction.jsp"></jsp:include>
			
			<!-- 页面主内容 -->
			<!-- END PAGE HEADER-->
			   <div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet-body">
						    
								  <div class="portlet">
									<div class="portlet-title">
										<div class="caption">
											<i class="fa fa-shopping-cart"></i>修改密码
										</div>
										<div class="actions btn-set">
											<button type="button" name="back" id="backBtn" class="btn default"><i class="fa fa-angle-left"></i> 返回</button>
											<button class="btn default" id="resetBtn" ><i class="fa fa-reply"></i> 撤销</button> 
										  </div>
									</div>	
								</div>
						  <div class="portlet-body form">
									<form action="${ctx}/admin/changePwdSubmit" method="post" id="form_pwd" class="form-horizontal">
										<div class="form-body">
											<!-- <h3 class="form-section">Advance validation. <small>Custom radio buttons, checkboxes and Select2 dropdowns</small></h3> -->
											<div class="alert alert-danger display-hide">
												<button class="close" data-close="alert"></button>
												表单中包含错误，请检查
											</div>
											<div class="alert alert-success display-hide">
												<button class="close" data-close="alert"></button>
												表单效验成功!
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">输入原密码
												<span class="required">
													 *
												</span>
												</label>
												<div class="col-md-4">
													<input type="password" name="oldpwd" data-required="1" class="form-control"/>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">输入新密码
												<span class="required">
													 *
												</span>
												</label>
												<div class="col-md-4">
													<input id="password" type="password" name="password" data-required="1" class="form-control"/>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3">再次输入新密码
												<span class="required">
													 *
												</span>
												</label>
												<div class="col-md-4">
													<input type="password" name="repassword" data-required="1" class="form-control"/>
												</div>
											</div>
										</div>
										<div class="form-actions fluid">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" id="submitBtn" class="btn green">提交</button>
												<button type="button" id="cancelBtn" class="btn default">取消</button>
											</div>
										</div>
									</form>
									<!-- END FORM-->
								</div><!-- END body form-->
						</div>
					</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
  <!-- BEGIN FOOTER -->
<jsp:include page="../back_common/commonFooter.jsp"></jsp:include>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<jsp:include page="../back_common/core/corePlugins.jsp"></jsp:include>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/jquery-validation/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/select2/select2.min.js"></script>



<script type="text/javascript" src="${ctx}/assets/plugins/fuelux/js/spinner.min.js"></script>

<script type="text/javascript" src="${ctx}/assets/plugins/jquery-inputmask/jquery.inputmask.bundle.min.js"></script>
<script src="${ctx}/assets/plugins/jquery.pwstrength.bootstrap/src/pwstrength.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-tags-input/jquery.tagsinput.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/typeahead/handlebars.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/typeahead/typeahead.min.js" type="text/javascript"></script>
<!-- dialog -->
<script src="${ctx}/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/assets/scripts/core/app.js" ></script>
<script src="${ctx}/assets/plugins/jquery-json/jquery.json-2.4.min.js" ></script>
<script src="${ctx}/assets/scripts/backend/back_common/serializeObjectPlugin.js" ></script>
<script src="${ctx}/assets/scripts/backend/back_common/globalConfigure.js" ></script>
<!-- 效验文件自定义实现form-validation.js -->
<script src="${ctx}/assets/scripts/backend/admin/form-pwd-validation.js" ></script>
<!-- 上传文件 -->
<script src="${ctx}/kindeditor/kindeditor.js"></script>
<script src="${ctx}/kindeditor/lang/zh_CN.js"></script>

<script type="text/javascript" language="javascript" class="init"> 

jQuery(document).ready(function() {   
	   App.init();
	   FormValidation.init();
	
	   $('#cancelBtn').on( 'click', function () {
	       window.location.href = "${ctx}/admin/index";
	    } );
	   
	   $('#backBtn').on( 'click', function () {
	       window.location.href = "${ctx}/admin/index";
	    } );
	   
	   $('#resetBtn').on( 'click', function () {
           $('#form_pwd')[0].reset();
	    } );
	   
});

</script>
</body>
</html>