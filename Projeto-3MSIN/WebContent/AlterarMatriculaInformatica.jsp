<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home - Alterar Matricula</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<jsp:useBean id="matriculaInformatica" class="to.MatriculaInformaticaTO"
		scope="request" />
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Matricula Artes#${matriculaInformatica.idMatricula}</h3>
		<!-- Formulario para alteração de matricula -->
		<form action="ManterMatriculaInformatica.do" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${matriculaInformatica.id}" />
				<div class="row">
					<div class="form-group col-md-4">
						<label for="idAluno">Id Aluno</label> <input type="number"
							class="form-control" name="idAluno" id="idAluno"
							placeholder="Informe o Aluno" pattern="[0-9]+$"
							title="Apenas numeros" value="${matriculaInformatica.idAluno}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="idCurso">Id Curso</label> <input type="number"
							class="form-control" name="idCurso" id="idCurso"
							placeholder="Informe o Curso" pattern="[0-9]+$"
							title="Apenas numeros" value="${matriculaInformatica.idCurso}">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-3">
						<label for="valor">Valor</label> <input type="number"
							class="form-control" name="valor" id="valor" placeholder="R$"
							pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
							title="Apenas numeros com ate 2 casas decimais. "
							value="${matriculaInformatica.valor}">
					</div>

					<div class="form-group col-md-3">
						<label for="statusPagamento">Status Pagamento</label> <select
							class="form-control" name="statusPagamento" id="statusPagamento">
							<option value="${matriculaInformatica.statusPagamento}">Selecione</option>
							<option value="Aberto">Aberto</option>
							<option value="Fechado">Fechado</option>
							<option value="Pendente Pagamento">Pendente Pagamento</option>
						</select>
					</div>

					<div class="form-group col-md-3">
						<label for="statusMatricula">Status Matricula</label> <select
							class="form-control" name="statusMatricula" id="statusMatricula">
							<option value="${matriculaInformatica.statusMatricula}">Selecione</option>
							<option value="Concluido">Concluido</option>
							<option value="Fechado">Fechado</option>
						</select>
					</div>
				</div>
				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary" name="acao"
							value="Alterar">Salvar</button>
						<a href="ListarMatriculaInformatica.jsp" class="btn btn-default">Cancelar</a>
					</div>
				</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>