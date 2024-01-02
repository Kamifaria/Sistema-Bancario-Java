<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
			<form id="form" action="SvLogin" method="get">
				<h2 class="titulo">Login</h2>
				<label for="iptLogin">Login:</label> <input id="iptLogin" placeholder="login" type="text" name="login" value="<%=request.getParameter("login") == null ? "" : request.getParameter("login")%>" />
				<br>
				 
				<label for="iptSenha">Senha:</label> <input id="iptSenha" placeholder="senha" type="text" name="senha" value="<%=request.getParameter("senha") == null ? "" : request.getParameter("senha")%>" />
				<br>
				
				<input type="submit" value="Login" class="btn" />
			</form>

			<% if (request.getAttribute("msg") == null) { %>
			<p></p>
			<% } else { %>
			<br> <br>
				<div class="div-localizar">
					<p><%=request.getAttribute("msg")%></p>
				</div>
			<% } %>
		</div>
	</main>
	
	<footer>&copy; Todos os direitos reservados</footer>


</body>
</html>