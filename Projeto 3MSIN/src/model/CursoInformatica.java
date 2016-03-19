package model;

import javax.swing.JOptionPane;

import daos.CursoInformaticaDAO;
import to.CursoInformaticaTO;

public class CursoInformatica {

	private int codigoInformatica;
	private String nomeCurso;
	private String dataInicio;
	private String dataTermino;
	private String horarioPrevisto;
	private int numeroVagas;
	private double valorCurso;
	private String softwares;
	private String numeroLaboratorios;

	public CursoInformatica() {

		codigoInformatica = 0;
		nomeCurso = "";
		dataInicio = "";
		dataTermino = "";
		horarioPrevisto = "";
		numeroVagas = 0;
		valorCurso = 0.0;
		softwares = "";
		numeroLaboratorios = "";

	}

	public CursoInformatica(String nome, String dataInicio, String dataTermino, String horarioPrevisto,
			int numeroVagas, double valorCurso, String softwares, String numeroLaboratorios) {
		this.nomeCurso = nome;
		this.softwares = softwares;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioPrevisto = horarioPrevisto;
		this.numeroVagas = numeroVagas;
		this.valorCurso = valorCurso;
		this.numeroLaboratorios = numeroLaboratorios;

	}


	//MÉTODOS DE ACESSO
	public int getCodigoInformatica() {
		return codigoInformatica;
	}

	public String getNome() {
		return nomeCurso;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	
	public String getDataTermino() {
		return dataTermino;
	}
	
	
	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}
	
	public int getNumeroVagas() {
		return numeroVagas;
	}

	public double getValorCurso() {
		return valorCurso;
	}
	
	public String getSoftwares() {
		return softwares;
	}
	
	public String getNumeroLaboratorios() {
		return numeroLaboratorios;
	}
	
	//MÉTODOS MODIFICADORES
	public void setCodigoInformatica(int codigoInformatica) {
		this.codigoInformatica = codigoInformatica;
	}

	

	public void setNome(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setHorarioPrevisto(String horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public void setSoftwares(String softwares) {
		this.softwares = softwares;
	}
		
	public void setNumeroLaboratorios(String numeroLaboratorios) {
		this.numeroLaboratorios = numeroLaboratorios;
	}

	// DADOS CURSOARTES
	public void dados() {
		String msg = "Código: " + codigoInformatica + "\nNome: " + nomeCurso + "\nData Inicio: " + dataInicio
				+ "\nData Termino: " + dataTermino + "\nHorário: " + horarioPrevisto + "\nNº Vagas: " + numeroVagas
				+ "\nValor: " + valorCurso + "\nNº Laboratório:" + numeroLaboratorios;

		JOptionPane.showMessageDialog(null, msg);
	}
    
	public void incluir() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(codigoInformatica);
		to.setNome(nomeCurso);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorios(numeroLaboratorios);
		dao.incluir(to);
	}
	
	public void alterar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		
		to.setNome(nomeCurso);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorios(numeroLaboratorios);
		dao.alterar(to);
		
	}
	
	public void consultar() {
			CursoInformaticaDAO dao = new CursoInformaticaDAO();
			CursoInformaticaTO to = dao.consultar(codigoInformatica);
			
			nomeCurso = to.getNome();
			dataInicio = to.getDataInicio();
			dataTermino = to.getDataTermino();
			horarioPrevisto = to.getHorarioPrevisto();
			numeroVagas = to.getNumeroVagas();
			valorCurso = to.getValorCurso();
			softwares = to.getSoftwares();
			numeroLaboratorios = to.getNumeroLaboratorios();
		}
	
	public void deletar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(codigoInformatica);
		dao.deletar(to);
	}

	public void consultarTodos() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		dao.consultarTodos();
	}
	
	public void retornarUltimoID(){
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		dao.retornarUltimoID();
	}
	

}