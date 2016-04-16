<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList, to.MatriculaArtesTO" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Matriculas Artes</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Matricula</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir esta matricula?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterMatriculaArtes.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
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
							<li><a href="#">Cursos</a></li>
							<li><a href="Listar_MatriculaArtes.html">Matricula Artes</a></li>
							<li><a href="Listar_MatriculaInformatica.html">Matricula Informatica</a></li>
							<li><a href="#">Ajuda</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Container Principal -->
            <div id="main" class="container-fluid">
                <form action="Listar_MatriculaArtes.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Matricula Artes</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Matriculas Artes (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="Criar_MatriculaArtes.html" class="btn btn-primary pull-right h2">Nova Matricula</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Id Matricula</th>
                                    <th>Id Aluno</th>
                                    <th>id Curso</th>
                                    <th>Status Pagamento</th>
                                    <th>Status Matricula</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% ArrayList<MatriculaArtesTO>lista = (ArrayList
                                    <MatriculaArtesTO>)request.getAttribute("lista"); for(MatriculaArtesTO to:lista){ %>
                                        <tr>
                                            <td><%=to.getCodigoMatricula()%></td>
                                            <td><%=to.getCodigoAluno()%></td>
                                            <td> <%=to.getCodigoCurso() %></td>
                                            <td><%=to.getStatusPagamento() %></td>
                                            <td> <%=to.getStatusMatricula() %></td>
                                            
                                            
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterMatriculaArtes.do?acao=Visualizar&id=<%=to.getCodigoMatricula()%>">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="ManterMatriculaArtes.do?acao=Editar&id=<%=to.getCodigoMatricula()%>">Editar</a>
                                                <button id="btn<%=to.getCodigoMatricula()%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-matriculaArtes="<%=to.getCodigoMatricula()%>">Excluir</button>
                                            </td>
                                        </tr>
                                        <% } %>
                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->

                    </div>
                </div>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('matriculaArtes');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>