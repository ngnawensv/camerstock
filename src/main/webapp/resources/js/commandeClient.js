function udapteDetailCommande(idCommande) {
	var json = $.parseJSON($("#json" + idCommande).text());
	var detailHtml = "";
	if (json) {
		for (var index = 0; index < json.length; index++) {
			detailHtml += "<tr>" + "<td>" + json[index].article.codeArticle
					+ "</td>" + "<td>" + json[index].quantite + "</td>"
					+ "<td>" + json[index].prixUnitaire + "</td>"
					+ "<td>0</td>" + 
					+ "<td>0</td>" +
					"</tr> "
					
		}
		$("#detailCommande").html(detailHtml);
	}

}