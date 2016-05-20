<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Criar Curso Artes</title>

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

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Curso #${cursoArtes.id}</h3>
		<!-- Formulario para inclusao de Curso Informatica -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${cursoArtes.id}" />
			<fieldset>
				<legend>Dados do curso</legend>
				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome" required
							maxlength="100" pattern="[a-zA-Z\s]+" placeholder="nome"
							value="${cursoArtes.nome}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-2">
						<label for="dataInicio">Data Inicio</label> <input type="date"
							name="dataInicio" placeholder="DataInicio" min="2016-01-01"
							class="form-control" onkeypress="mascara(this, '##/##/####')"
							maxlength="10" value="${cursoArtes.dataInicio}" />
					</div>

					<div class="form-group col-md-2">
						<label for="dataTermino">Data Termino</label> <input type="date"
							name="dataTermino" placeholder="Data Termino" min="2016-01-01"
							class="form-control" onkeypress="mascara(this, '##/##/####')"
							maxlength="10" value="${cursoArtes.dataTermino}" />
					</div>

					<div class="form-group col-md-2">
						<label for="dataNasc">Horario Previsto</label> <input type="time"
							class="form-control" name="horarioPrevisto"
							value="${cursoArtes.horario}" />

					</div>
					
				</div>

				<div class="row">
					<div class="form-group col-md-2">
						<label for="vagas">Vagas</label> <input type="text" name="vagas"
							class="form-control" placeholder="Nº Vagas" pattern="[0-9]+$"
							title="Apenas numeros" value="${cursoArtes.vagas}" />
					</div>


					<div class="form-group col-md-2">
						<label for="valor">Valor</label> <input type="text" name="valor"
							placeholder="Valor Curso" pattern="[0-9]+([\.,][0-9]+)?"
							class="form-control" step="0.01"
							title="Apenas numeros com ate 2 casas decimais. "
							value="${cursoArtes.valor}" />
					</div>


					<div class="form-group col-md-2">
						<label for="cep">Livros: </label> <input type="text" name="livros"
							size=25 placeholder="Descricao do material que será utilizado"
							class="form-control" pattern="[a-zA-Z0-9 ,\s]+"
							title="Caracter não permitido" value="${cursoArtes.livros}" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-2">
						<label for="software">Descricao Material</label> <input
							type="text" name="descricaoMaterial" size=45 placeholder="Livros"
							class="form-control" 
							pattern="[a-zA-Z0-9 ,\s]+" title="Caracter invalido"
							value="${cursoArtes.descricaoMaterial}" />
					</div>
				</div>	
			</fieldset>
			<hr />
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="AlterarCursoArtes">Salvar</button>
					<a href="ListarCursoArtes.jsp" class="btn btn-default">Cancelar</a>
				</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>