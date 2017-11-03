<%@ include file="/public/jsp/common.jsp"%>
<%@ page pageEncoding="UTF-8"%>
<cj:override name="heads">
	<!-- jquery ui -->
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.core.css"/>
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.all.css"/>
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.button.css"/>
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.dialog.css"/>
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.datepicker.css"/>
	<cj:head type="css" url="/html/juithemes/base/jquery.ui.tabs.css"/>
	<!-- info-center -->
	<cj:head type="css" url="/uom-apps/information/bulletin.css" />
	<!-- jquery ui -->
	<cj:head type="js" url="/html/js/jquery/effects.core.js" />
	<cj:head type="js" url="/html/js/jquery/effects.slide.js" />
	<!-- dwr -->
	<cj:head type="js" url="/uom-apps/dwr/engine.js" />
	<cj:head type="js" url="/uom-apps/dwr/interface/informationAction.js" />
	<!-- utils -->
	<cj:head type="js" url="/uom-apps/public/fullcalendar/fullcalendar.min.js" />
	<cj:head type="js" url="/uom-apps/public/utils/jq.js" />
	<cj:head type="js" url="/uom-apps/public/utils/dialog.js" />
	<cj:head type="js" url="/uom-apps/public/utils/date.js" />
	<!-- info-center -->
	<cj:head type="js" url="/uom-apps/information/bulletin.js" />
	<cj:head type="js" url="/uom-apps/information/bul-image.js" />
	<%@include file="../public/utils/portal-env.jspf"%>
</cj:override>
<cj:override name="bodyContent">
	<div class="ib-bulletin" cat="image" style='text-align:center;margin-top:0;margin-left:0;margin-right:0'>
		<div class="ib-image"></div>
		<div class="ib-title"></div>
	</div>
</cj:override>
<%-- extends templates --%>
<%@ include file="/templates/portlet_tpl.jspf" %>