/**
 * 
 */
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import to.AlunoTO;

/**
 * @author
 *
 */

@WebServlet("/ManterAluno.do")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pAcao 	  = request.getParameter("acao");
		String pCodigo 	  = request.getParameter("id");
		String pNome 	  = request.getParameter("nome");
		String pEmail 	  = request.getParameter("email");
		String pDataNasc  = request.getParameter("dataNascimento");
		String pRG 		  = request.getParameter("rg");
		String pCPF 	  = request.getParameter("cpf");
		String pTelefone  = request.getParameter("telefone");
		String pEndereco  = request.getParameter("endereco");
		String pCEP  	  = request.getParameter("cep");
		String pCidade	  = request.getParameter("cidade");
		String pEstado 	  = request.getParameter("estado");
		
		int codigo = 0;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {}
		
		Aluno aluno = new Aluno(codigo, pNome, pCPF, pRG, pDataNasc,pTelefone,pEmail ,
		pEndereco,pCEP, pCidade, pEstado );

		if (pAcao.equals("Inserir")) {
			aluno.incluir();
		} else if (pAcao.equals("Excluir")) {
			aluno.deletar();
		} else if (pAcao.equals("Alterar")) {
			aluno.alterar();
		} else if (pAcao.equals("Consultar")) {
			aluno.consultar();
		}
		aluno.consultar();

		AlunoTO to = new AlunoTO();
		to.setCodigo(aluno.getCodigo());
		to.setNome(aluno.getNome());
		to.setCPF(aluno.getCPF());
		to.setRG(aluno.getRG());
		to.setDataNasc(aluno.getDataNasc());
		to.setTelefone(aluno.getTelefone());
		to.setEmail(aluno.getEmail());
		to.setEndereco(aluno.getEndereco());
		to.setCEP(aluno.getCEP());
		to.setCidade(aluno.getCidade());
		to.setEstado(aluno.getEstado());

		request.setAttribute("aluno", to);

		RequestDispatcher view = request.getRequestDispatcher("Aluno.jsp");
		view.forward(request, response);
	}

}