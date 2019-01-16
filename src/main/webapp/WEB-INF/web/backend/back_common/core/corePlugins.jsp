<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>

<!--[if lt IE 9]>
<script src="${ctx}/assets/plugins/respond.min.js"></script>
<script src="${ctx}/assets/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${ctx}/assets/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.4.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ctx}/assets/plugins/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- 全局配置 -->
<script src="${ctx}/assets/scripts/backend/back_common/globalConfigure.js"></script>
<script>
var ctxPath = "${ctx}";

</script>