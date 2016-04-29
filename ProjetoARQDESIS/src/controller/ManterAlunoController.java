package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import to.AlunoTO;
import to.ListaAlunoTO;

@WebServlet("/ManterAluno.do")
public class ManterAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
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

		Aluno aluno = new Aluno(codigo, pNome, pCPF, pRG, pDataNasc, pTelefone, pEmail, pCEP, pEndereco, pCidade,
				                pEstado);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			aluno.incluir();
			ArrayList<AlunoTO> lista = new ArrayList<>();
			lista.add(aluno.getTO());
			ListaAlunoTO listaAluno = new ListaAlunoTO();
			listaAluno.setAlunos(lista);
			request.setAttribute("lista", listaAluno);
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Excluir")) {
			aluno.deletar();
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Alterar")) {
			aluno.alterar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("ConsultarAluno.jsp");
		} else if (pAcao.equals("Visualizar")) {
			aluno.consultar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("ConsultarAluno.jsp");
		} else if (pAcao.equals("Editar")) {
			aluno.consultar();
			request.setAttribute("aluno", aluno.getTO());
			view = request.getRequestDispatcher("AlterarAluno.jsp");
		}

		view.forward(request, response);
	}

}