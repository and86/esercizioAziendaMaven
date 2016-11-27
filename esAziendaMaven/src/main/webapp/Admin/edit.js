function confirmDeleteDipendente(){	
	
	var result = confirm ("Vuoi davvero eliminare questo utente?");
	
	if (result == true){
		document.getElementById("formElimina").action = "doCancellaDipendente.jsp";
	}
}


function confirmDeleteCliente(){	
	
	var result = confirm ("Vuoi davvero eliminare questo utente?");
	
	if (result == true){
		document.getElementById("formElimina").action = "doCancellaCliente.jsp";
	}
}


//function confirmDeleteBustaPaga(){	
//	
//	var result = confirm ("Vuoi davvero eliminare questa busta paga?");
//	
//	if (result == true){
//		document.getElementById("formModifiche").action = "doEliminaBustaPaga.jsp";
//	}
//}

//function confirmDeleteVoce(){	
//	
//	var result = confirm ("Vuoi davvero eliminare questa voce?");
//	
//	if (result == true){
//		document.getElementById("formModifiche").action = "doEliminaVoce.jsp";
//	}
//}