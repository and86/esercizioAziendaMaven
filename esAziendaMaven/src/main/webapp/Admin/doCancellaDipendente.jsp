<%@page import="it.alfasoft.andrea.servizio.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<%
	Servizi s = new Servizi();

long id = Long.parseLong(request.getParameter("id_utente"));

s.eliminaDipendenteConId(id);

messaggio.setMessaggio("Cliente eliminato");
	
	%>

<jsp:forward page="ElencoDipendenti.jsp" />