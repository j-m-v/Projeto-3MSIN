<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.CursoArtesTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CursoArtes</title>
</head>
<body>
	<%CursoArtesTO to = (CursoArtesTO)request.getAttribute("cursoArtes"); %>
	codigoArtes: <%=to.getCodigoArtes()%><br>
	nomeCurso: <%=to.getNomeArtes()%><br>
	dataInicio: <%=to.getDataInicio() %><br>
	dataTermino: <%=to.getDataTermino() %><br>
	horarioPrevisto: <%=to.getHorarioPrevisto() %><br>
	numeroVagas: <%=to.getNumeroVagas() %><br>
	valorCurso: <%=to.getValorCurso() %><br>
	livros: <%=to.getLivros() %><br>
	descricaoMaterial: <%=to.getDescricaoMaterial() %><br>
</body>
</html>