<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<form action="SvCadastrarCC" method="get">
				<h2>Cadastrar Conta Corrente</h2>
				
				<label for="lblAgencia">Agência:</label>
				<input id="iptAgencia" placeholder="Agencia" type="text" name="agencia" value="<%=request.getParameter("agencia") == null ? "" : request.getParameter("agencia")%>"/>
				<br><br>
				
				<label for="lblNrConta">Nr Conta:</label>
				<input id="iptNrConta" placeholder="NrConta" type="text" name="nrConta" value="<%=request.getParameter("nrConta") == null ? "" : request.getParameter("nrConta")%>"/>
				<br><br>
				
				<label for="lblUser">Nome:</label>
				<input id="iptUser" placeholder="Nome" type="text" name="nome" value="<%=request.getParameter("nome") == null ? "" : request.getParameter("nome")%>"/>
				<br><br>
				
				<label for="lblCpf">CPF:</label>
				<input id="iptCpf" placeholder="CPF" type="text" name="cpf" value="<%=request.getParameter("cpf") == null ? "" : request.getParameter("cpf")%>"/>
				<br><br>
				
				<label for="lblEmail">E-mail:</label>
				<input id="iptEmail" placeholder="Email" type="text" name="email" value="<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>"/>
				<br><br>
	
				<label for="lblSaldo">Saldo:</label>
				<input id="iptSaldo" placeholder="Saldo" type="text" name="saldo" value="<%=request.getParameter("saldo") == null ? "" : request.getParameter("saldo")%>"/>
				<br>
				
				<label for="lblLimite">Limite:</label>
				<input id="iptLimite" placeholder="Limite" type="text" name="limite" value="<%=request.getParameter("limite") == null ? "" : request.getParameter("limite")%>"/>
				<br><br>

				<input type="submit" value="Cadastrar" class="btn" />
			</form>
			<% if (request.getAttribute("msg") == null) { %>
			<p></p>
			<% } else { %>
			<br><br>
				<div class="div-localizar">
					<p><%=request.getAttribute("msg")%></p>
				</div>
			<% } %>
		</div>
	</main>
	<footer>&copy; Todos os direitos reservados</footer>

</body>
</html>