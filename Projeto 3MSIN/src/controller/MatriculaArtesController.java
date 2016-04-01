 	package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MatriculaArtes;
import to.MatriculaArtesTO;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterMatriculaArtes.do")
	public class MatriculaArtesController extends HttpServlet {
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
			String pAcao = request.getParameter("acao");
			String pIdMatricula = request.getParameter("idMatricula");
			String pIdAluno= request.getParameter("idAluno");
			String pIdCurso= request.getParameter("idCurso");
			String pValorMatricula= request.getParameter("valorMatricula");
			String pStatusMatricula= request.getParameter("statusMatricula");
			String pStatusPagamento= request.getParameter("statusPagamento");
			
			int idMatricula = 0;
			try {
				idMatricula = Integer.parseInt(pIdMatricula);
			} catch (NumberFormatException e) {}
			
			int idAluno = 0;
			try {
				idAluno = Integer.parseInt(pIdAluno);
			} catch (NumberFormatException e) {}
			
			int idCurso = 0;
			try {
				idCurso = Integer.parseInt(pIdCurso);
			} catch (NumberFormatException e) {}
			
			double valorMatricula = 0;
			try {
				valorMatricula = Double.parseDouble(pValorMatricula);
			} catch (NumberFormatException e) {}
			
			MatriculaArtes matricula = new MatriculaArtes();
			String data = matricula.dataAtual();
			MatriculaArtes matriculaArtes = new MatriculaArtes(idMatricula, data,  valorMatricula, pStatusMatricula, pStatusPagamento, idAluno, idCurso);

			if (pAcao.equals("Inserir")) {
				matriculaArtes.incluir();
			} else if (pAcao.equals("Excluir")) {
				matriculaArtes.deletar();
			} else if (pAcao.equals("Alterar")) {
				matriculaArtes.alterar();
			} else if (pAcao.equals("Consultar")) {
				matriculaArtes.consultar();
			}
			

			MatriculaArtesTO to = new MatriculaArtesTO();
			to.setCodigoMatricula(matriculaArtes.getCodigoMatricula());
			to.setCodigoAluno(matriculaArtes.getCodigoAluno());
			to.setCodigoCurso(matriculaArtes.getCodigoCurso());
			to.setDataMatricula(matriculaArtes.getDataMatricula());
			to.setValorMatricula(matriculaArtes.getValorMatricula());
			to.setStatusMatricula(matriculaArtes.getStatusMatricula());
			to.setStatusPagamento(matriculaArtes.getStatusPagamento());

			request.setAttribute("matriculaArtes", to);

			RequestDispatcher view = 
						request.getRequestDispatcher("MatriculaArtes.jsp");
			view.forward(request, response);
		}

	

}
