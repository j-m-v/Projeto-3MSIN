<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
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
            <jsp:useBean id="cursoInformatica" class="to.CursoInformaticaTO" scope="request" />   
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
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${cursoInformatica.id}" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirCursoArtes">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
               <c:import url="Menu.jsp" />
               
               <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Curso #${cursoInformatica.id}</h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${cursoInformatica.nome}
                            </p>
                        </div>
                    </div>
                    
                  <div class="row">
                        <div class="col-md-2">
                            <p><strong>Data Inicio</strong>
                            </p>
                            <p>
                                ${cursoInformatica.dataInicio}
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Data Termino</strong>
                            </p>
                            <p>
                                ${cursoInformatica.dataTermino}
                            </p>
                        </div>
                        
                         <div class="col-md-2">
                            <p><strong>Horario Previsto</strong>
                            </p>
                            <p>
                                ${cursoInformatica.horario}
                            </p>
                        </div>
                  </div>
                  <div class="row">  
                        <div class="col-md-3">
                            <p><strong>Vagas</strong>
                            </p>
                            <p>
                                ${cursoInformatica.vagas}
                            </p>
                        </div>
    
                        <div class="col-md-8">
                            <p><strong>Valor</strong>
                            </p>
                            <p>
                                ${cursoInformatica.valor}
                            </p>
                        </div>
                  
                  
                        <div class="col-md-4">
                            <p><strong>Softwares</strong>
                            </p>
                            <p>
                                ${cursoInformatica.softwares}
                            </p>
                        </div>
                  </div>      
				  <div class="row">
                        <div class="col-md-7">
                            <p><strong>Numero laboratorio</strong>
                            </p>
                            <p>
                                ${cursoInformatica.numeroLaboratorio}
                            </p>
                        </div>
    
                  
                  </div>
                  
                  
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarCursoInformaticaword&id=${cursoInformatica.id} class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarCursoInformatica.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>
        
        
        </html>
