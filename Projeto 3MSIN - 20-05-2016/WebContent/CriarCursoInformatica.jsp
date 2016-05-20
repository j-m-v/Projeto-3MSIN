<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Curso Informatica</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.css" rel="stylesheet">
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
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp" />


	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Novo curso :</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<fieldset>
				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome:</label> <input type="text"
							class="form-control" name="nome" id="nome" required
							maxlength="100" pattern="[a-zA-Z\s]+" placeholder="nome">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-8">
						<label for="dataInicio">Data Inicio:</label> <input type="date"
							class="form-control" name="dataInicio" placeholder="DataInicio"
							onkeypress="mascara(this, '##/##/####')" maxlength="10" />
					</div>

					<div class="form-group col-md-8">
						<label for="dataTermino">Data Termino:</label> <input type="date"
							class="form-control" name="dataTermino"
							placeholder="Data Termino" min="2016-01-01"
							onkeypress="mascara(this, '##/##/####')" maxlength="10" />
					</div>

					<div class="form-group col-md-3">
						<label for="livros">Horario:</label> <select class="form-control"
							name="horario" id="horario">
							<option value="">Selecione</option>
							<option value="08:00h">08:00h</option>
							<option value="19:30h">19:30h</option>
						</select>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label for="vagas">Vagas:</label> <input type="text" name="vagas"
							class="form-control" placeholder="Nº Vagas" pattern="[0-9]+$"
							title="Apenas numeros" />
					</div>


					<div class="form-group col-md-8">
						<label for="valor">Valor:</label> <input type="text" name="valor"
							class="form-control" placeholder="Valor Curso"
							pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
							title="Apenas numeros com ate 2 casas decimais. " />
					</div>

					<div class="form-group col-md-3">
						<label for="softwares">Softwares:</label> <select class="form-control"
							name="softwares" id="softwares">
							<option value="">Selecione</option>
							<option value="eclipse">Eclipse</option>
							<option value="netbeans">Netbeans</option>
							<option value="photoshop">Photoshop CS4</option>
							<option value="corel">CorelDrawn x7</option>
							<option value="jgrasp">Jgrasp</option>
						</select>
					</div>

					<div class="form-group col-md-3">
						<label for="numeroLaboratorio">Numero Laboratorio:</label> <select class="form-control"
							name="numeroLaboratorio" id="numeroLaboratorio">
							<option value="">Selecione</option>
							<option value="um">1</option>
							<option value="dois">2</option>
							<option value="tres">3</option>
							<option value="quatro">4</option>
							<option value="cinco">5</option>
						</select>
					</div>
				</div>
			</fieldset>
			<br></br>

			<div class="botoes">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarCursoInformatica">Salvar</button>
					<a href="index.html" class="btn btn-default">Cancelar</a>
				</div>

			</div>
		</form>
</body>


</html>
