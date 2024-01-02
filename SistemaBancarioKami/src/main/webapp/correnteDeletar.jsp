<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deletar Conta Corrente</title>
<link href="estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header class="area-cabecalho">
		<h1>Sistema Bancário <span>STEP</span></h1>
		<nav class="area-menu">
			<a href="index.html">Home</a> 
			<a href="login.jsp">Login</a> 
			<a href="index.html">Contato</a> 
			<a href="index.html">Sobre</a>
		</nav>
	</header>
	
	<main>
		<div class="div-form">
			<form id="form" action="SvDeletarCC" method="get">
				<h2 class="titulo">Deletar Conta Corrente</h2>
				<label for="iptId">ID:</label> <input id="iptId" placeholder="id" type="text" name="id" value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
				<br> 
				
				<input type="submit" value="Deletar" class="btn" />
			</form>

			<% if (request.getAttribute("msg") == null) { %>
			<p></p>
			<% } else { %>
			<br> <br>
				<div class="div-localizar">
					<p><%= request.getAttribute("msg") %></p>
				</div>
			<% } %>
		</div>
	</main>

	<footer>&copy; Todos os direitos reservados</footer>
	
	

</body>
</html>