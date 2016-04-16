<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList, to.CursoArtesTO" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Cursos Artes</title>

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
                            <h4 class="modal-title" id="modalLabel">Excluir Curso</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este Curso?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterCursoArtes.do" method="post">
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
                            <li><a href="Listar_CursosArtes.html">Cursos Artes</a>
                            </li>
                            <li><a href="#">Aluno</a>
                            </li>
                            <li><a href="#">Matriculas</a>
                            </li>
                            <li><a href="#">Curso informatica</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Container Principal -->
            <div id="main" class="container-fluid">
                <form action="Listar_CursoArtes.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Curso</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Curso Artes (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="Criar_CursoArtes.html" class="btn btn-primary pull-right h2">Novo Curso</a>
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
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Data de inicio</th>
                                    <th>Data de termino</th>
									<th>Horario previsto</th>
                                    <th>Numero de vagas</th>
                                    <th>Valor</th>
                                    <th>Livros</th>
                                    <th>Descricao material</th>

                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% ArrayList<CursoArtesTO>lista = (ArrayList
                                    <CursoArtesTO>)request.getAttribute("lista"); for(CursoArtesTO to:lista){ %>
                                        <tr>
                                            <td>
                                                <%=to.getCodigoArtes()%>
                                            </td>
                                            <td>
                                                <%=to.getNomeArtes() %>
                                            </td>
                                            <td>
                                                <%=to.getDataInicio() %>
                                            </td>
                                            <td>
                                                <%=to.getDataTermino() %>
                                            </td>

  					    <td>
                                               <%=to.getHorarioPrevisto()%>
                                            </td>
                                            <td>
                                                <%=to.getNumeroVagas() %>
                                            </td>
                                            <td>
                                                <%=to.getValorCurso() %>
                                            </td>
                                            <td>
                                                <%=to.getLivros() %>
                                            </td>
					    <td>
                                             <%=to.getDescricaoMaterial() %>
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterCursoArtes.do?acao=Visualizar&id=<%=to.getCodigoArtes()%>">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="ManterCursoArtes.do?acao=Editar&id=<%=to.getCodigoArtes()%>">Editar</a>
                                                <button id="btn<%=to.getCodigoArtes()%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cursoArtes="<%=to.getCodigoArtes()%>">Excluir</button>
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
                    var recipient = button.data('cliente');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>
