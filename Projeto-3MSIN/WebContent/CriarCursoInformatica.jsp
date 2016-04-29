<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	 function mascara(t, mask){
		 var i = t.value.length;
		 var saida = mask.substring(1,0);
		 var texto = mask.substring(i)
		 if (texto.substring(0,1) != saida){
		 t.value += texto.substring(0,1);
		 }
		 }
	 </script>


<body>
    <!-- Barra superior com os menus de navegacao -->
  	<c:import url="Menu.jsp"/>
  	
  	
<!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Novo curso :</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="ManterCursoInformatica.do" method="post">
            <!-- area de campos do form -->
            <div class="row">	    
			   


		<br><form action="ManterCursoInformatica.do" method="post">
		<fieldset>
	<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" name="nome" id="nome" required
							maxlength="100" pattern="[a-zA-Z\s]+" placeholder="nome">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-2">
					     <label for="dataInicio">Data Inicio</label> <input type="date" name="dataInicio" 						placeholder="DataInicio" min="2016-01-01" onkeypress="mascara(this, '##/##/####')" maxlength="10"  />
    					</div>

					<div class="form-group col-md-2">
						<label for="dataTermino">Data Termino</label> <input type="date" name="dataTermino" placeholder="Data Termino" min="2016-01-01" onkeypress="mascara(this, '##/##/####')" maxlength="10" />
					</div>

					<div class="form-group col-md-2">
						<label for="dataNasc">Horario Previsto</label> <input type="time" name="horarioPrevisto"/>        

					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-2">
					     <label for="vagas">Vagas</label> <input type="text" name="vagas" placeholder="Nº Vagas" pattern="[0-9]+$" title="Apenas numeros"/>
    					</div>

				
					<div class="form-group col-md-2">
					     <label for="valor">Valor</label> <input type="text" name="valor" placeholder="Valor Curso" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" title = "Apenas numeros com ate 2 casas decimais. " />
    					</div>

				
					<div class="form-group col-md-2">
						<label for="vagas">Nº Laboratório</label> <input type="text" name="numeroLaboratorio" placeholder="Nº Laboratorio" pattern="[0-9]+$" title="Apenas numeros"/>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-2">
					     <label for="DescricaoMaterial">Software:</label> <input type="text" name="software" size=50 placeholder="Descricao do material que será utilizado" pattern="[a-zA-Z0-9 ,\s]+" title= "Caracter não permitido"/>
    				</div>

				</div>

			  
		</fieldset>
		
		  </table><br></br>
		
	<div class="botoes">
			<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Criar">Salvar</button>
					<a href="index.html" class="btn btn-default">Cancelar</a>
			</div>
			
	</div>
     </form>
	</body>

        
</html>
