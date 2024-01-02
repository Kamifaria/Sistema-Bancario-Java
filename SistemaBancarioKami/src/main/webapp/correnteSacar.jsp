<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saque Conta Corrente</title>
<link href="estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
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
			<form action="SvSacarCC" method="get">
				<h2>Saque Conta Corrente</h2>
				
				<label for="iptId">ID:</label>
				<input id="iptId" placeholder="ID" type="text" name="id" value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"/>
				<br>
				
				<label for="iptValorSaque">Valor Saque:</label>
				<input id="iptValorSaque" placeholder="Valor Saque" type="text" name="valorSaque" value="<%=request.getParameter("valorSaque") == null ? "" : request.getParameter("valorSaque")%>"/>
				<br>
				
				<input type="submit" value="Sacar" class="btn" />
			</form>
			<% if (request.getAttribute("msg") == null) { %>
			<p></p>
			<% } else { %>
			<br><br>
				<div class="div-localizar">
					<br>
					<p><%=request.getAttribute("msg")%></p>
				</div>
			<% } %>
		</div>
	</main>
	<footer>&copy; Todos os direitos reservados</footer>
	
	

</body>
</html>