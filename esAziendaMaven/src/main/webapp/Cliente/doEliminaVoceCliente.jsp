<%@page import="model.Rubrica"%>
<%@page import="it.alfasoft.andrea.servizio.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="cliente" class="it.alfasoft.andrea.bean.Cliente"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />


<%
Servizi s=new Servizi();

long id=Long.parseLong(request.getParameter("id_voce"));

String usern=cliente.getUsername();
Rubrica r=s.cercaRubricaConUser(usern);

s.eliminaVoce(r, id);
messaggio.setMessaggio("Voce eliminata");
%>
<jsp:forward page="ElencoVociCliente.jsp" />





