<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ page import="to.CursoArtesTO" %>
 
  <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Visualizar Curso</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>
        
         <body>
            <%CursoArtesTO to=(CursoArtesTO)request.getAttribute( "curso"); %>
                <!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Curso</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este Curso?
                            </div>
                            <div class="modal-footer">
                                <form action="ManterCursoArtes.do" method="post">
                                    <input type="hidden" name="id" value="<%=to.getCodigoArtes()%>" />
                                    <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
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
                    <h3 class="page-header">Visualizar Curso #<%=to.getCodigoArtes() %></h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                <%=to.getNomeArtes()%>
                            </p>
                        </div>
                    </div>
                    
                  <div class="row">
                        <div class="col-md-2">
                            <p><strong>CPF</strong>
                            </p>
                            <p>
                                <%=to.getDataInicio() %>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>RG</strong>
                            </p>
                            <p>
                                <%=to.getDataTermino() %>
                            </p>
                        </div>
                        
                         <div class="col-md-2">
                            <p><strong>Data de Nascimento</strong>
                            </p>
                            <p>
                                <%=to.getHorarioPrevisto() %>
                            </p>
                        </div>
                  </div>
                  <div class="row">  
                        <div class="col-md-3">
                            <p><strong>Celular</strong>
                            </p>
                            <p>
                                <%=to.getNumeroVagas()%>
                            </p>
                        </div>
    
                        <div class="col-md-8">
                            <p><strong>Email</strong>
                            </p>
                            <p>
                                <%=to.getValorCurso()%>
                            </p>
                        </div>
                  
                  
                        <div class="col-md-4">
                            <p><strong>Email</strong>
                            </p>
                            <p>
                                <%=to.getLivros()%>
                            </p>
                        </div>
                  </div>      
				  <div class="row">
                        <div class="col-md-7">
                            <p><strong>Endereço</strong>
                            </p>
                            <p>
                                <%=to.getDescricaoMaterial()%>
                            </p>
                        </div>
    
                  
                  </div>
                  
                  
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="ManterCursoArtes.do?acao=Editar&id=<%=to.getCodigoArtes()%>" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="Listar_CursoArtes.html" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>
        
        
        </html>