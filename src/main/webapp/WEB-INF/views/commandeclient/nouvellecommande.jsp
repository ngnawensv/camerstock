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
					<h1 class="page-header"><spring:message code="common.commadeclient.nouveau"/></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<spring:message code="common.commadeclient.details"></spring:message>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<form  action="" enctype="multipart/form-data" role="form">
								<div class="form-group">
									<label><spring:message code="common.codeArticle"></spring:message></label> 
									<input class="form-control" placeholder="Code"/>
								</div>
								<div class="form-group">
									<label><spring:message code="common.date"></spring:message></label> 
									<input class="form-control" placeholder="Date"/>
								</div>
								<div class="form-group">
									<label><spring:message code="common.client"></spring:message></label> 
									<select class="form-control" id="listeClients">
										<c:forEach items="${clients }" var="client">
											<option value="${client.getIdClient()}">${client.getNom()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="panel-footer">
								<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<spring:message code="common.enregistrer"></spring:message></i></button>
								<a href="<c:url value="/commandeclient/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<spring:message code="common.annuler"></spring:message></i></a>
								</div>
							</form>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <spring:message code="common.commadeclient.details"></spring:message>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                        <th><spring:message code="common.article"></spring:message></th>
                                            <th><spring:message code="common.quantite"></spring:message></th>
                                            <th><spring:message code="common.prixUnitaireTTC"></spring:message></th>
                                            <th><spring:message code="common.total"></spring:message></th>
                                        </tr>
                                    </thead>
                                    <tbody id="detailNouvelleCommande">
                                                                
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
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
