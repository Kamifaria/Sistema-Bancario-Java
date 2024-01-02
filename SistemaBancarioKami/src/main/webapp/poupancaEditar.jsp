<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Conta Poupança</title>
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
			<form action="SvEditarCP" method="get">
				<h2>Editar Conta Poupança</h2>
				
				<label for="iptId">ID:</label>
				<input id="iptId" placeholder="ID" type="text" name="id" value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"/>
				<br>
				
				<label for="editar">Escolha o Atributo:</label>
				<select id="editar" name="editar">
					<option value="nome">Nome</option>
					<option value="cpf">CPF</option>
					<option value="email">Email</option>
				</select>
				<br>
				
				<label for="iptNovoValor">Novo Valor:</label>
				<input id="iptNovoValor" placeholder="Novo Valor" type="text" name="novoValor" value="<%=request.getParameter("novoValor") == null ? "" : request.getParameter("novoValor")%>"/>
				<br>
				
				
				<input type="submit" value="Editar" class="btn" />
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