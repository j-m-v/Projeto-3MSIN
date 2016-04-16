<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="to.CursoArtesTO"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Criar Curso</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<script language="JavaScript" type="text/javascript">
	function mascara(t, mask) {
		var i = t.value.length;
		var saida = mask.substring(1, 0);
		var texto = mask.substring(i)
		if (texto.substring(0, 1) != saida) {
			t.value += texto.substring(0, 1);
		}
	}
</script>

<%
	CursoArtesTO to = (CursoArtesTO) request.getAttribute("cursoArtes");
%>
<body>
	<!-- Barra superior com os menus de navegação -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Home</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Listar_Alunos.html">Alunos</a></li>
					<li><a href="#">Cursos Artes</a></li>
					<li><a href="#">Cursos Informatica</a></li>
					<li><a href="#">Matricula Artes</a></li>
					<li><a href="#">Matricula Informatica</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Curso #<%=to.getCodigoArtes() %></h3>
		<!-- Formulario para inclusao de Curso Artes -->
		<form action="ManterCursoArtes.do" method="post">
			<!-- area de campos do form -->
			 <input type="hidden" name="id" value="<%=to.getCodigoArtes() %>" />

			<fieldset>
					<table>
		      
			 <div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome" required
							maxlength="100" pattern="[a-zA-Z\s]+" placeholder="nome"value="<%=to.getNomeArtes()%>">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-2">
					     <label for="dataInicio">Data Inicio</label> <input type="date" name="dataInicio" placeholder="DataInicio" min="2016-01-01" onkeypress="mascara(this, '##/##/####')" maxlength="10" value="<%=to.getDataInicio()%>" />
    					</div>

					<div class="form-group col-md-2">
						<label for="dataTermino">Data Termino</label> <input type="date" name="dataTermino" placeholder="Data Termino" min="2016-01-01" onkeypress="mascara(this, '##/##/####')" maxlength="10"value="<%=to.getDataTermino()%>" />
					</div>

					<div class="form-group col-md-2">
						<label for="dataNasc">Horario Previsto</label> <input type="time" name="horarioPrevisto"value="<%=to.getHorarioPrevisto()%>"/>        

					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-2">
					     <label for="vagas">Vagas</label> <input type="text" name="vagas" placeholder="Nº Vagas" pattern="[0-9]+$" title="Apenas numeros"value="<%=to.getNumeroVagas()%>"/>
    					</div>

				
					<div class="form-group col-md-2">
					     <label for="valor">Valor</label> <input type="text" name="valor" placeholder="Valor Curso" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" title = "Apenas numeros com ate 2 casas decimais. " value="<%=to.getValorCurso()%>"/>
    					</div>

				
					<div class="form-group col-md-2">
						<label for="livros">Livros</label> <input type="text" name="Livros" size=25 placeholder="livros" pattern="[a-zA-Z0-9 ,\s]+" title= "Caracter não permitido"value="<%=to.getLivros()%>"/>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-2">
					     <label for="DescricaoMaterial">Descricao Material</label> <input type="text" name="DescricaoMaterial" size=45 placeholder="Descricao Material" pattern="[a-zA-Z0-9 ,\s]+" title="Caracter invalido"value="<%=to.getDescricaoMaterial()%>"/>
    			</div>


			 </fieldset>
			<hr />
			
	<div class="botoes">
			<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Alterar">Salvar</button>
					<a href="Listar_CursosArtes.html" class="btn btn-default">Cancelar</a>
			</div>

		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
