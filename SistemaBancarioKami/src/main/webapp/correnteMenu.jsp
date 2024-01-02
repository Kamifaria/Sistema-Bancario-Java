<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Corrente</title>
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
				<h2 class="titulo">Conta Corrente</h2>
				<ul class="menu-ul">
					<li><a href="correnteCadastrar.jsp">Cadastrar</a></li>
					<li><a href="correnteLocalizar.jsp">Localizar</a></li>
					<li><a href="correnteDeletar.jsp">Deletar</a></li>
					<li><a href="correnteEditar.jsp">Editar</a></li>
					<li><a href="correnteSacar.jsp">Sacar</a></li>
					<li><a href="correnteDepositar.jsp">Depositar</a></li>
					<li><a href="correnteSaldo.jsp">Exibir Saldo</a></li>
				</ul>
				
				<button onclick="window.location.href='menu.jsp';" class="btn">Voltar</button>
		</div>
	</main>
	
	<footer>&copy; Todos os direitos reservados</footer>
	
</body>
</html>