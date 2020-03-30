$(document).ready(function(){
	$("#tauxTva").on("keyup", function(){
		//alert("TVA event");
		tvaKeyUpFonction();
	});
});

tvaKeyUpFonction=function(){
	var prixUnitaireHT=$("#prixUnitaireHT").val();
	var tauxTva=$("#tauxTva").val();
	var prixUnitaireTTC=parseFloat(parseFloat(prixUnitaireHT)*parseFloat(tauxTva)/100 + parseFloat(prixUnitaireHT));
	$("#prixUnitaireTTC").val(prixUnitaireTTC);
	
}