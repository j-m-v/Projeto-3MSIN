<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.AlunoTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aluno</title>
</head>
<body>
	<%AlunoTO to = (AlunoTO)request.getAttribute("aluno"); %>
	codigo: <%=to.getCodigo()%><br>
	nome: <%=to.getNome()%><br>
	endereco: <%=to.getEndereco() %><br>
	telefone: <%=to.getTelefone() %><br>
	email: <%=to.getEmail() %><br>
	rg: <%=to.getRG() %><br>
	cpf: <%=to.getCPF() %><br>
	cep: <%=to.getCEP() %><br>
	dataNasc: <%=to.getDataNasc() %><br>
	cidade: <%=to.getCidade() %><br>
	estado: <%=to.getEstado() %><br>
</body>
</html>