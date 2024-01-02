<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
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
		<div class="container">
			<div class="menu-cc">
				<h2 class="titulo">Conta Corrente</h2>
				<ul class="menu-ul">
					<li><a href="correnteMenu.jsp">MENU</a></li>
				</ul>
			</div>

			<div class="menu-cp">
				<h2 class="titulo">Conta Poupança</h2>
				<ul class="menu-ul">
					<li><a href="poupancaMenu.jsp">MENU</a></li>
				</ul>
			</div>		
		</div>
	</main>
	
	<footer>&copy; Todos os direitos reservados</footer>
	
</body>
</html>