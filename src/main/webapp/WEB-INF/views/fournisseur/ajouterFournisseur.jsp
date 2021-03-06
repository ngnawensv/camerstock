<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><spring:message code="common.app.titre"/></title>

<!-- Core CSS - Include with every page -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<!-- Page-Level Plugin CSS - Blank -->

<!-- SB Admin CSS - Include with every page -->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin.css"
	rel="stylesheet">

</head>

<body>

	<div id="wrapper">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="margin-bottom: 0">

			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>
			<!-- /.navbar-top-links -->
			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"><spring:message code="common.fournisseur.nouveau"></spring:message></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<spring:message code="common.fournisseur.nouveau"></spring:message>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<c:url value="/fournisseur/enregistrer" var="urlEnregistrer"/>
							<f:form modelAttribute="fournisseur" action='${urlEnregistrer}' enctype="multipart/form-data" role="form">
								<f:hidden path="idFournisseur"/>
								<f:hidden path="photo"/>
								<div class="form-group">
									<label><spring:message code="common.nom"></spring:message></label> 
									<f:input path="nom" class="form-control" placeholder="Nom"/>
								</div>
								<div class="form-group">
									<label><spring:message code="common.prenom"></spring:message></label> 
									<f:input path="prenom" class="form-control" placeholder="Prenom"/>
								</div>
								<div class="form-group">
									<label><spring:message code="common.adresse"></spring:message></label> 
									<f:input path="adresse" class="form-control" placeholder="Adresse"/>
								</div>
								<div class="form-group">
									<label><spring:message code="common.email"></spring:message></label> 
									<f:input path="mail" class="form-control" placeholder="Email"/>
								</div>
								<div class="form-group">
                                            <label><spring:message code="common.photo"></spring:message></label>
                                            <input type="file" name="file">
                                        </div>
								<div class="panel-footer">
								<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<spring:message code="common.enregistrer"></spring:message></i></button>
								<a href="<c:url value="/fournisseur/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<spring:message code="common.annuler"></spring:message></i></a>
								</div>
							</f:form>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Core Scripts - Include with every page -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

	<!-- Page-Level Plugin Scripts - Blank -->

	<!-- SB Admin Scripts - Include with every page -->
	<script src="<%=request.getContextPath()%>/resources/js/sb-admin.js"></script>

	<!-- Page-Level Demo Scripts - Blank - Use for reference -->

</body>

</html>
