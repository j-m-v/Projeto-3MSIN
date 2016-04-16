<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="to.AlunoTO"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Aluno</title>

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
	AlunoTO to = (AlunoTO) request.getAttribute("aluno");
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
		<h3 class="page-header">Alterar Aluno #<%=to.getCodigo() %></h3>
		<!-- Formulario para inclusao de Alunos -->
		<form action="ManterAluno.do" method="post">
			<!-- area de campos do form -->
			 <input type="hidden" name="id" value="<%=to.getCodigo() %>" />
			<fieldset>
				<legend>Dados Aluno</legend>
				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome" required
							maxlength="100"  pattern="[a-zA-Záéíóúç\s]+" placeholder="nome completo"
							value="<%=to.getNome()%>">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-2">
						<label for="cpf">CPF</label> <input type="text"
							class="form-control" name="cpf" id="cpf"
							onkeypress="mascara(this, '###.###.###-##')" maxlength="14"
							pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"
							placeholder="Ex:000.000.000-00"
							value="<%=to.getCPF()%>">
					</div>

					<div class="form-group col-md-2">
						<label for="rg">RG</label> <input type="text" class="form-control"
							name="rg" id="rg" onkeypress="mascara(this, '##.###.###-#')"
							maxlength="12" pattern="\d{2}\.\d{3}\.\d{3}-\d{1}"
							placeholder="Ex: 11.111.111-1"
							value="<%=to.getRG()%>">
					</div>
					<div class="form-group col-md-2">
						<label for="dataNasc">Data de Nascimento</label> <input
							type="date" class="form-control" name="dataNasc" id="dataNasc"
							onkeypress="mascara(this, '##/##/####')" maxlength="10"
							pattern="[0-9]+[/]+[0-9]+[/]+[0-9]+$"
							placeholder="Ex: 11/11/1111"
							value="<%=to.getDataNasc()%>">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-3">
						<label for="telefone">Celular</label> <input type="tel"
							class="form-control" name="telefone" id="telefone" maxlength="15"
							pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}"
							placeholder="Ex: (99) 99999-9999"
							value="<%=to.getTelefone()%>">
					</div>
					<div class="form-group col-md-4">
						<label for="email">E-Mail</label> <input type="email"
							class="form-control" name="email" id="email" required
							maxlength="60" placeholder="email obrigatório"
							value="<%=to.getEmail()%>">
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Endereço</legend>
				<div class="row">
					<div class="form-group col-md-7">
						<label for="telefone">Endereço</label> <input type="text"
							class="form-control" name="endereco" id="endereco" required
							maxlength="100" placeholder="Informe o endereço: Rua, n°, Bairro"
							value="<%=to.getEndereco()%>">
					</div>
					<div class="form-group col-md-2">
						<label for="cep">CEP</label> <input type="text"
							class="form-control" name="cep" id="cep"
							onkeypress="mascara(this, '#####-##')" maxlength="8"
							pattern="\d{5}\-\d{2}" placeholder="Ex: 00000-00"
							value="<%=to.getCEP()%>">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label for="cidade">Cidade</label> <input type="text"
							class="form-control" name="cidade" id="cidade" required
							maxlength="60"  pattern="[a-zA-Záéíóúç\s]+"
							placeholder="Informe a cidade"
							value="<%=to.getCidade()%>">
					</div>
					<div class="form-group col-md-2">

						<label for="estado">Estado</label> 
						<select class="form-control"
							name="estado" id="estado">
							<option value="<%=to.getEstado()%>"></option>
							<option value="AC">AC</option>
							<option value="AL">AL</option>
							<option value="AM">AM</option>
							<option value="AP">AP</option>
							<option value="BA">BA</option>
							<option value="CE">CE</option>
							<option value="DF">DF</option>
							<option value="ES">ES</option>
							<option value="GO">GO</option>
							<option value="MA">MA</option>
							<option value="MG">MG</option>
							<option value="MS">MS</option>
							<option value="MT">MT</option>
							<option value="PA">PA</option>
							<option value="PB">PB</option>
							<option value="PE">PE</option>
							<option value="PI">PI</option>
							<option value="PR">PR</option>
							<option value="RJ">RJ</option>
							<option value="RN">RN</option>
							<option value="RS">RS</option>
							<option value="RO">RO</option>
							<option value="RR">RR</option>
							<option value="SC">SC</option>
							<option value="SE">SE</option>
							<option value="SP">SP</option>
							<option value="TO">TO</option>
						</select>
					</div>
				</div>
			</fieldset>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Alterar">Salvar</button>
					<a href="Listar_Alunos.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>