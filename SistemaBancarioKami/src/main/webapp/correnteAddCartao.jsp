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
			<form action="SvAddCartaoCC" method="get">
				<h2>Cadastrar Cartão</h2>
				
				<label for="iptId">ID:</label>
				<input id="iptId" placeholder="ID" type="text" name="id" value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"/>
				<br>
				
				<label for="lblNomeCartao">Nome:</label>
	    			<input id="iptNomeCartao" placeholder="Nome Cartao" type="text" name="nomeCartao" value="<%=request.getParameter("nomeCartao") == null ? "" : request.getParameter("nomeCartao")%>"/>
	    			<br>
				
    				<label for="lblNumeroCartao">Número:</label>
	    			<input id="iptNumeroCartao" placeholder="Numero Cartao" type="text" name="numeroCartao" value="<%=request.getParameter("numeroCartao") == null ? "" : request.getParameter("numeroCartao")%>"/>
	    			<br>
	    			
	    			<label for="lblCodigoCartao">Código:</label>
	    			<input id="iptCodigoCartao" placeholder="Codigo Cartao" type="text" name="codigoCartao" value="<%=request.getParameter("codigoCartao") == null ? "" : request.getParameter("codigoCartao")%>"/>
	    			<br>
	    			
	    			<label for="lblBandeiraCartao">Bandeira:</label>
	    			<input id="iptBandeiraCartao" placeholder="Bandeira Cartao" type="text" name="bandeiraCartao" value="<%=request.getParameter("bandeiraCartao") == null ? "" : request.getParameter("bandeiraCartao")%>"/>
	    			<br>
		    			
	    			<label for="lblLimiteCartao">Limite:</label>
	    			<input id="iptLimiteCartao" placeholder="Limite Cartao" type="text" name="limiteCartao" value="<%=request.getParameter("limiteCartao") == null ? "" : request.getParameter("limiteCartao")%>"/>
	    			<br>

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