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
	
	  <!-- Page-Level Plugin CSS - Tables -->
    <link href="<%=request.getContextPath()%>/resources/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

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
					<h1 class="page-header"><fmt:message key="common.fournisseur"/></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
			<div class="col-lg-12">
			<ol class="breadcrumb">
			<li><a href="<c:url value="/fournisseur/nouveau"/>" ><i class="fa fa-plus">&nbsp;<fmt:message key="common.ajouter"></fmt:message></i></a></li>
			<li><a href="#"><i class="fa fa-download">&nbsp;<fmt:message key="common.exporter"></fmt:message></i></a></li>
			<li><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message key="common.importer"></fmt:message></i></a></li>
			
			</ol>
			
			</div>
			
			</div>
			 <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message key="common.fournisseur.liste"></fmt:message>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th><fmt:message key="common.photo"></fmt:message></th>
                                            <th><fmt:message key="common.nom"></fmt:message></th>
                                            <th><fmt:message key="common.prenom"></fmt:message></th>
                                            <th><fmt:message key="common.adresse"></fmt:message></th>
                                            <th><fmt:message key="common.email"></fmt:message></th>
                                            <th><fmt:message key="common.actions"></fmt:message></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${fournisseurs }" var="fournisseur">
                                    <tr class="odd gradeX">
                                            <td><img src="${fournisseur.getPhoto()}" width="90px" height="90px"/></td>
                                            <td>${fournisseur.getNom()}</td>
                                            <td>${fournisseur.getPrenom()}</td>
                                            <td class="center">${fournisseur.getAdresse()}</td>
                                            <td class="center">${fournisseur.getMail()}</td>
                                            <td>
                                            <c:url value="/fournisseur/modifier/${fournisseur.getIdFournisseur()}" var="urlModifier"/>
                                            <a href="${urlModifier}"><i class="fa fa-edit"></i></a>
                                            &nbsp;|&nbsp;
                                            <a href="javascript:void(0);" data-toggle="modal" data-target="#modalClient${fournisseur.getIdFournisseur()}"><i class="fa fa-trash-o"></i></a>                                           
						                         <div class="modal fade" id="modalClient${fournisseur.getIdFournisseur()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						                             <div class="modal-dialog">
						                                 <div class="modal-content">
						                                     <div class="modal-header">
						                                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						                                         <h4 class="modal-title" id="myModalLabel"><fmt:message key="common.confirmer.suppression"/></h4>
						                                     </div>
						                                     <div class="modal-body">
						                                     <fmt:message key="common.fournisseur.confirmer.suppression.msg"/>
						                                     </div>
						                                     <div class="modal-footer">
						                                         <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="common.annuler"/></button>
						                                         <c:url value="/fournisseur/supprimer/${fournisseur.getIdFournisseur() }" var="urlSuppression" />
						                                         <a href="${urlSuppression}" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;<fmt:message key="common.confirmer"/></a>
						                                     </div>
						                                 </div>
						                                 <!-- /.modal-content -->
						                             </div>
						                             <!-- /.modal-dialog -->
						                         </div>
                          						<!-- /.modal -->
                                            </td>
                                        </tr>
                                    </c:forEach>                                        
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
		
		    <!-- Page-Level Plugin Scripts - Tables -->
    <script src="<%=request.getContextPath()%>/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
    
    <script src="<%=request.getContextPath()%>/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- Page-Level Plugin Scripts - Blank -->

	<!-- SB Admin Scripts - Include with every page -->
	<script src="<%=request.getContextPath()%>/resources/js/sb-admin.js"></script>

	<!-- Page-Level Demo Scripts - Blank - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    </script>

</body>

</html>
