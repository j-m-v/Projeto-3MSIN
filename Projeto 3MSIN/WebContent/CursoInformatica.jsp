<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.CursoInformaticaTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CUrsoInformatica</title>
</head>
<body>
	<%CursoInformaticaTO to = (CursoInformaticaTO)request.getAttribute("cursoInformatica"); %>
	codigoInformatica: <%=to.getCodigoInformatica()%><br>
	nomeCurso: <%=to.getNome()%><br>
	dataInicio: <%=to.getDataInicio() %><br>
	dataTermino: <%=to.getDataTermino() %><br>
	horarioPrevisto: <%=to.getHorarioPrevisto() %><br>
	numeroVagas: <%=to.getNumeroVagas() %><br>
	valorCurso: <%=to.getValorCurso() %><br>
	softwares: <%=to.getSoftwares() %><br>
	numeroLaboratorios: <%=to.getNumeroLaboratorios() %><br>
</body>
</html>