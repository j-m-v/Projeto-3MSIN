<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.MatriculaArtesTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MatriculaArtes</title>
</head>
<body>
	<%MatriculaArtesTO to = (MatriculaArtesTO)request.getAttribute("matriculaArtes"); %>
	codigoMatricula: <%=to.getCodigoMatricula() %><br>
	codigoAluno: <%=to.getCodigoAluno() %><br>
	codigoCurso: <%=to.getCodigoCurso() %><br>
	dataMatricula: <%=to.getDataMatricula() %><br>
	valorMatricula: <%=to.getValorMatricula() %><br>
	statusMatricula: <%=to.getStatusMatricula() %><br>
	statusPagamento: <%=to.getStatusPagamento() %><br>
</body>
</html>