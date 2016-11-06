<%@page import="it.alfasoft.andrea.servizio.Servizi"%>
<%@page import="it.alfasoft.andrea.bean.Cliente"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="user" class="it.alfasoft.andrea.bean.Utente"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<% 
String nome_m= request.getParameter("nome1");
String cognome_m= request.getParameter("cognome1");
String username_m= request.getParameter("username1");
String password_m= request.getParameter("password1");
String rS_m= request.getParameter("ragioneSociale1");
String pIva_m= request.getParameter("pIva1");

// out.println(nome_m);

Cliente c=new Cliente(nome_m,cognome_m,username_m,password_m,'c',rS_m,pIva_m);

Servizi s=new Servizi();

if(c.isValid()){
	password_m=s.codificaPass(password_m);
	c.setPassword(password_m);
	s.aggiornaCliente(c);
	messaggio.setMessaggio("Cliente modificato");

	
%>
<jsp:forward page="ElencoClienti.jsp" />
<% 
}else {
	messaggio.setMessaggio("Errore");
	%>
<jsp:forward page="ElencoClienti.jsp" />
<% 
}
	
	%>





