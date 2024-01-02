<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposito Conta Corrente</title>
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
			<form action="SvDepositarCC" method="get">
				<h2>Depósito Conta Corrente</h2>
				
				<label for="iptId">ID:</label>
				<input id="iptId" placeholder="ID" type="text" name="id" value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"/>
				<br>
				
				<label for="iptValorDeposito">Valor Depósito:</label>
				<input id="iptValorDeposito" placeholder="Valor Deposito" type="text" name="valorDeposito" value="<%=request.getParameter("valorDeposito") == null ? "" : request.getParameter("valorDeposito")%>"/>
				<br>
				
				<input type="submit" value="Depositar" class="btn" />
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