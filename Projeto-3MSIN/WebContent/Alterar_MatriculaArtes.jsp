<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="to.MatriculaArtesTO" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Matricula</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
            <%MatriculaArtesTO to=( MatriculaArtesTO)request.getAttribute( "matriculaArtes"); %>
                <!-- Barra superior com os menus de navegação -->
                <nav class="navbar navbar-inverse navbar-fixed-top">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="index.html">Home</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
							<li><a href="Listar_Alunos.html">Alunos</a></li>
							<li><a href="#">Cursos</a></li>
							<li><a href="Listar_MatriculaArtes.html">Matricula Artes</a></li>
							<li><a href="Listar_MatriculaInformatica.html">Matricula Informatica</a></li>
							<li><a href="#">Ajuda</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Matricula #<%=to.getCodigoMatricula() %></h3>
                    <!-- Formulario para alteração de Matricula	 -->
                    <form action="ManterMatriculaArtes.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="<%=to.getCodigoMatricula() %>" />
                         <div class="row">
		                <div class="form-group col-md-4">
		                    <label for="idAluno">Id Aluno</label>
		                    <input type="number" class="form-control" name="idAluno" id="idAluno" placeholder="Informe o Aluno" pattern="[0-9]+$" title="Apenas numeros" value="<%=to.getCodigoAluno()%>">
		                </div>
		         </div>
		         <div class="row">
		                <div class="form-group col-md-4">
		                    <label for="idCurso">Id Curso</label>
		                    <input type="number" class="form-control" name="idCurso" id="idCurso" placeholder="Informe o Curso" pattern="[0-9]+$" title="Apenas numeros" value="<%=to.getCodigoCurso()%>">
		                </div>
		         </div>   
		         <div class="row">
		                <div class="form-group col-md-3">
		                    <label for="valor">Valor</label>
		                    <input type="number" class="form-control" name="valor" id="valor" placeholder="R$" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" title = "Apenas numeros com ate 2 casas decimais. " value="<%=to.getValorMatricula()%>" >
		                </div>
		
		                <div class="form-group col-md-3">
		                    <label for="statusPagamento">Status Pagamento</label>
		                        <select class ="form-control" name = "statusPagamento" id= "statusPagamento">
				                	<option value="<%=to.getStatusPagamento()%>">Selecione</option>
									<option value="Aberto">Aberto</option>
				                	<option value="Fechado">Fechado</option>
				                	<option value="Pendente Pagamento">Pendente Pagamento</option>
				                </select>
				        </div>  
				        
				        <div class="form-group col-md-3">
		                    <label for="statusMatricula">Status Matricula</label>
		                        <select class ="form-control" name = "statusMatricula" id= "statusMatricula">
				                	<option value="<%=to.getStatusMatricula()%>">Selecione</option>
									<option value="Concluido">Concluido</option>
		                			<option value="Fechado">Fechado</option>
				                </select>
				        </div>       
		         </div>
		         <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
	                    <a href="index.html" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>         
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>