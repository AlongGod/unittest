<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../back_common/taglib.jsp" %>
<!DOCTYPE html>
<jsp:include page="../back_common/ieCompatibility.jsp"></jsp:include>
<html  class="no-js">
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>

<title>TestCase管理</title>
<!-- BEGIN PACE PLUGIN FILES -->
<jsp:include page="../back_common/core/pacePluginFiles.jsp"></jsp:include>
<!-- END PACE PLUGIN FILES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<jsp:include page="../back_common/core/globalMandatoryStyles.jsp"></jsp:include>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/plugins/select2/select2-metronic.css"/>
<link rel="stylesheet" href="${ctx}/assets/plugins/data-tables/DT_bootstrap.css"/>
<!-- 图片按钮 -->
<link href="${ctx}/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<jsp:include page="../back_common/core/themeStyles.jsp"></jsp:include>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="${ctx}/favicon.ico"/>

<style type="text/css" class="init">
/* div.container {
	width: 100%;
} */
/* 
th,td {
	white-space: nowrap;
}
td.highlight {
	background-color: whitesmoke !important;
}

th,td {
	white-space: nowrap;
}

body { font-size: 140%; } */
</style>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-fixed">
<!-- BEGIN HEADER -->
   <jsp:include page="../back_common/bodyHeader.jsp"></jsp:include>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	 <jsp:include page="../back_common/sidebar.jsp"></jsp:include>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="deleteBasic" tabindex="-1" role="basic" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">删除</h4>
						</div>
						<div class="modal-body">
							 确定要删除该条记录吗？
						</div>
						<div class="modal-footer">
							<button type="button" id="cancelBtn" name="cancelBtn"  class="btn default" data-dismiss="modal">取消</button>
							<button type="button" id="okBtn" name="okBtn"  class="btn blue" data-dismiss="modal">确定</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE HEADER-->
			<jsp:include page="../back_common/commonAction.jsp"></jsp:include>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
				
				     <div class="tabbable tabbable-custom boxless tabbable-reversed">
						<ul class="nav nav-tabs">
							<li>
								<a href="#tab_0" data-toggle="tab">
									TestCase管理
								</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade" id="tab_0">
								<!-- <a name="addTestCaseBtn" href="javascript:;" onclick="addTestCase()" class="btn default btn-sm blue ">
								<i class="fa fa-edit"></i> 添加</a> -->
								<!-- BEGIN EXAMPLE TABLE PORTLET-->
								 <jsp:include page="tabs/testCaseManagement-tab.jsp"></jsp:include> 
								<!-- END EXAMPLE TABLE PORTLET-->
							</div>
						</div>
					</div>
					
				</div>
			</div>
			
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<jsp:include page="../back_common/commonFooter.jsp"></jsp:include>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<jsp:include page="../back_common/core/corePlugins.jsp"></jsp:include>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="${ctx}/assets/plugins/data-tables/DT_bootstrap.js"></script>
<!-- dialog -->
<script src="${ctx}/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${ctx}/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<!-- 图片按钮 -->
<script type="text/javascript" src="${ctx}/assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<script src="${ctx}/assets/scripts/core/app.js"></script>
<script src="${ctx}/assets/scripts/custom/search.js"></script>
<script src="${ctx}/assets/plugins/jquery-json/jquery.json-2.4.min.js" ></script>
<script src="${ctx}/assets/scripts/backend/back_common/serializeObjectPlugin.js" ></script>
<script src="${ctx}/assets/scripts/backend/back_common/datatable.js"></script>
<script src="${ctx}/assets/scripts/backend/testCase/testCaseManagement-table-ajax.js"></script>
<script>
var oTestCaseManagementTable;
var activeTab = "${activeTab}";
var testCaseManagementURL = "${ctx}/backendtestCase/queryTestCaseMap";
jQuery(document).ready(function() {

    $("#businessModuleManagementMenu").addClass("active");
    $("#testCaseManageMenu").addClass("active");
    $("#menu_1").text("业务管理");
    $("#menu_2").text("TestCase管理");
    App.init();
    oTestCaseManagementTable =  TestCaseTableAjax.init();
    
    $(".nav-tabs").find("li").each(function(index){ 
       var id = $(this).find("a").attr("href");
       if(id == ("#"+activeTab)) {
         $(this).attr("class","active");
       }
	} );
	
    $(".tab-pane").each(function(index){ 
       var id = $(this).attr("id");
       if(id == activeTab) {
         $(this).attr("class","tab-pane fade active in");
       }else {
         $(this).attr("class","tab-pane fade");
       }
	} );

    
     /****************************TestCase管理*************************************/
     

    $("#testCaseManagement tbody tr").click( function( e ) {
        if ( $(this).hasClass('active') ) {
            $(this).removeClass('active');
        }
        else {
            oTestCaseManagementTable.$('tr.active').removeClass('active');
            $(this).addClass('active');
        } 
    });

    $('#testCaseManagement_addBtn').on( 'click', function () {
	       window.location.href = "${ctx}/backendtestCase/newTestCase";
	    } );
    $(".dataTables_filter").hide();
});

function editTestCase(queryParams) {
    var arr = queryParams.split(",");
    window.location.href = "${ctx}/backendtestCase/"+arr[0]+"/editTestCase";
}

function deleteTestCase(queryParams) {
   var arr = queryParams.split(",");
   
    bootbox.dialog({
        		 message: "确定要删除这条记录吗?",
                 //title: "Custom title",
                 buttons: {
                  main: {
                     label: "取消",
                     //className: "green",
                     callback: function() {
                     
                     }
                   },
                   success: {
                     label: "确定",
                     //className: "red",
                     callback: function() {
                    	    $.ajax({  
				                type : 'POST',  
				                url :"${ctx}/backendtestCase/"+arr[0]+"/remove" ,  
		                       // data:{"id" : arr[0]} ,
				                dataType : 'json', 
				                async : false,  //同步
				                success : function(data) {
				                	  
				                	 window.location.href = "${ctx}/backendtestCase/testCaseManagement/?activeTab=tab_0";
				                },  
				                error : function() {  
				                   //serverError3.show();
				                }  
				            });   
				            
                     }
                   }
                 }
             });
}

function fnGetSelected( oTableLocal )
{
    return oTableLocal.$('tr.active');
}
</script>
</body>
<!-- END BODY -->
</html>