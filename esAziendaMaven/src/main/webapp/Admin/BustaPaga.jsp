<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="java.util.List"%>
<%@page import="it.alfasoft.andrea.servizio.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page=".././headerHtml.jsp"></jsp:include>
<jsp:include page=".././navBar.jsp"></jsp:include>
<jsp:include page="menuLateraleAdmin.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="admin" class="it.alfasoft.andrea.bean.Admin"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript" src="BustePaga.js"></script>

<%
	if (admin.isValid()) {
%>

<div class="ch-container">
	<div class="row">



		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>


				<ul class="breadcrumb">
					<li><a href="../Admin/HomePageAdmin.jsp">Home</a></li>
					<li><a href="#">Emissione Nuova Busta Paga </a></li>
				</ul>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-euro"></i> Nuova Busta Paga
								</h2>


							</div>

							<div class="control-group" align="center">
								<label class="control-label" for="selectError2">Lista
									Dipendenti<br> (Cognome-Nome)
								</label>

								<div class="controls">
									<select data-placeholder="Dipendente" id="selection"
										data-rel="chosen" style="width: 200px;">
										<option value=""></option>
										<%
											Servizi s = new Servizi();
												List<Dipendente> lista = s.getListDipendenti();
												session.setAttribute("lista", lista);
										%>

										<c:forEach items="${lista}" var="u">
											<option><c:out value="${u.cognome} ${u.nome} " /></option>
										</c:forEach>

									</select>
								</div>
							</div>


							<div class="box-content" align="center">
								<form class="form-horizontal" action="doBustaPaga.jsp"
									method="post">
									<div class="form-group">
										<label>Data di emissione</label><br> <input type="text" id="dataEm"
											name="dataEmissione" placeholder="Emission Date"
											style="width: 200px;" required><br> <label>Importo</label><br>
										<input type="number" name="importo" placeholder="Subtotal"
											style="width: 200px;" required><br> <input
											type="hidden" value="${u.id_utente}" name="id_utente">
										<br> <input type="submit" class="btn btn-primary"
											value="Emetti"> <font size="4" color="red"><%=messaggio.getMessaggio()%></font>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-default" data-dismiss="modal">Close</a> <a
					href="#" class="btn btn-primary" data-dismiss="modal">Save
					changes</a>
			</div>
		</div>
	</div>
</div>


<jsp:include page=".././footer.jsp"></jsp:include>







<%
	} else {
		response.sendRedirect(".././Accesso/Login.jsp");
	}
%>