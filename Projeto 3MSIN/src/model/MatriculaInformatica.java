package model;

import daos.MatriculaInformaticaDAO;
import to.MatriculaInformaticaTO;

public class MatriculaInformatica {
	// Atributos
	private int codigoMatricula;
	private int codigoAluno;
	private int codigoCurso;
	private String dataMatricula;
	private double valorMatricula;
	private String statusMatricula;
	private String statusPagamento;

	public MatriculaInformatica() {
		codigoMatricula = 0;
		codigoAluno = 0;
		codigoCurso = 0;
		dataMatricula = "";
		valorMatricula = 0.0;
		statusMatricula = "";
	}

	public MatriculaInformatica(String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.codigoAluno = codigoAluno;
		this.codigoCurso = codigoCurso;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}

	public int getCodigoMatricula() {
		return codigoMatricula;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public double getValorMatricula() {
		return valorMatricula;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public void setValorMatricula(double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public void incluir() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.incluir(to);
	}

	public void alterar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.alterar(to);
	}

	public void consultar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = dao.consultar(codigoMatricula);
		codigoAluno = to.getCodigoAluno();
		codigoCurso = to.getCodigoCurso();
		dataMatricula = to.getDataMatricula();
		valorMatricula = to.getValorMatricula();
		statusMatricula = to.getStatusMatricula();
		statusPagamento = to.getStatusPagamento();
	}
	
	public void deletar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoMatricula(codigoMatricula);
		dao.deletar(to);
	}

	public void consultarTodos() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		dao.consultarTodos();
	}

	public void retornarUltimoID() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		dao.retornarUltimoID();
	}
}