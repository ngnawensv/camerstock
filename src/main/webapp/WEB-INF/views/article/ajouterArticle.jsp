<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Start Bootstrap - SB Admin Version 2.0 Demo</title>

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
					<h1 class="page-header"><fmt:message key="common.article.nouveau"></fmt:message></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<fmt:message key="common.article.nouveau"></fmt:message>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<c:url value="/article/enregistrer" var="urlEnregistrer"/>
							<f:form modelAttribute="article" action='${urlEnregistrer}' enctype="multipart/form-data" role="form">
								<f:hidden path="idArticle"/>
								<f:hidden path="photo"/>
								<div class="form-group">
									<label><fmt:message key="common.codeArticle"></fmt:message></label> 
									<f:input path="codeArticle" class="form-control" placeholder="Code de l'article"/>
								</div>
								<div class="form-group">
									<label><fmt:message key="common.designation"></fmt:message></label> 
									<f:input path="designation" class="form-control" placeholder="D�signation"/>
								</div>
								<div class="form-group">
									<label><fmt:message key="common.prixUnitaireHT"></fmt:message></label> 
									<f:input id="prixUnitaireHT" path="prixUnitaireHT" class="form-control" placeholder="Prix unitaire hors taxe"/>
								</div>
								<div class="form-group">
									<label><fmt:message key="common.tauxTva"></fmt:message></label> 
									<f:input id="tauxTva" path="tauxTva" class="form-control" placeholder="Taux TVA"/>
								</div>
								<div class="form-group">
									<label><fmt:message key="common.prixUnitaireTTC"></fmt:message></label> 
									<f:input id="prixUnitaireTTC" path="prixUnitaireTTC" class="form-control" placeholder="Prix unitaire toute taxe comprise" disabled="true"/>
								</div>
								<div class="form-group">
									<label><fmt:message key="common.categorie"></fmt:message></label> 
									<f:select path="categorie.idCategorie" items="${categories }" itemLabel="code" itemValue="idCategorie" class="form-control" placeholder="categorie"></f:select>
								</div>
								<div class="form-group">
                                            <label><fmt:message key="common.photo"></fmt:message></label>
                                            <input type="file" name="file">
                                        </div>
								<div class="panel-footer">
								<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message key="common.enregistrer"></fmt:message></i></button>
								<a href="<c:url value="/article/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<fmt:message key="common.annuler"></fmt:message></i></a>
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
	
	<!-- Script de calcul automatique du prixUnitaireTTC -->
	<script src="<%=request.getContextPath()%>/resources/js/article.js"></script>

	<!-- Page-Level Demo Scripts - Blank - Use for reference -->

</body>

</html>