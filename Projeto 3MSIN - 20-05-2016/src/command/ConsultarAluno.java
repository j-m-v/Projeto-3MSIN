package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import to.AlunoTO;

public class ConsultarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pDataNasc = request.getParameter("dataNasc");
		String pRG = request.getParameter("rg");
		String pCPF = request.getParameter("cpf");
		String pTelefone = request.getParameter("telefone");
		String pEndereco = request.getParameter("endereco");
		String pCEP = request.getParameter("cep");
		String pCidade = request.getParameter("cidade");
		String pEstado = request.getParameter("estado");
		int codigo = 0;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {
		}

		Aluno aluno = new Aluno(codigo, pNome, pCPF, pRG, pDataNasc, pTelefone, 
								pEmail, pCEP, pEndereco, pCidade,pEstado);
		RequestDispatcher view = null;

		aluno.consultar();
		request.setAttribute("aluno", aluno.getTO());
		view = request.getRequestDispatcher("ConsultarAluno.jsp");
		view.forward(request, response);
	}

	public int busca(Aluno aluno, ArrayList<AlunoTO> lista) {
		AlunoTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == aluno.getId()) {
				return i;
			}
		}
		return -1;
	}

}
