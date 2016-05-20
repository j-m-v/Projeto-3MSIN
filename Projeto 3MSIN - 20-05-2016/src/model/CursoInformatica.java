package model;


import java.util.ArrayList;

import dao.CursoInformaticaDAO;
import to.CursoInformaticaTO;

public class CursoInformatica {

	private int id;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private String horario;
	private int vagas;
	private double valor;
	private String softwares;
	private String numeroLaboratorio;

	public CursoInformatica() {

		id = 0;
		nome = "";
		dataInicio = "";
		dataTermino = "";
		horario = "";
		vagas = 0;
		valor = 0.0;
		softwares = "";
		numeroLaboratorio = "";

	}

	public CursoInformatica(String nome, String dataInicio, String dataTermino, String horarioPrevisto, int numeroVagas,
			double valorCurso, String softwares, String numeroLaboratorios) {
		this.nome = nome;
		this.softwares = softwares;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horarioPrevisto;
		this.vagas = numeroVagas;
		this.valor = valorCurso;
		this.numeroLaboratorio = numeroLaboratorios;
	}
	
	public CursoInformatica(int codigo, String nome, String dataInicio, String dataTermino, String horarioPrevisto, int numeroVagas,
			double valorCurso, String softwares, String numeroLaboratorios) {
		this.id = codigo;
		this.nome = nome;
		this.softwares = softwares;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horarioPrevisto;
		this.vagas = numeroVagas;
		this.valor = valorCurso;
		this.numeroLaboratorio = numeroLaboratorios;
	}
	
	

	// MÉTODOS DE ACESSO
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public String getHorario() {
		return horario;
	}

	public int getVagas() {
		return vagas;
	}

	public double getValor() {
		return valor;
	}

	public String getSoftwares() {
		return softwares;
	}

	public String getNumeroLaboratorio() {
		return numeroLaboratorio;
	}

	// MÉTODOS MODIFICADORES
	public void setId(int codigoInformatica) {
		this.id = codigoInformatica;
	}

	public void setNome(String nomeCurso) {
		this.nome = nomeCurso;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setHorario(String horarioPrevisto) {
		this.horario = horarioPrevisto;
	}

	public void setVagas(int numeroVagas) {
		this.vagas = numeroVagas;
	}

	public void setValor(double valorCurso) {
		this.valor = valorCurso;
	}

	public void setSoftwares(String softwares) {
		this.softwares = softwares;
	}

	public void setNumeroLaboratorio(String numeroLaboratorios) {
		this.numeroLaboratorio = numeroLaboratorios;
	}

	public void incluir() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorio(numeroLaboratorio);
		dao.incluir(to);
		setId(to.getId());
	}
	
	public CursoInformaticaTO getTO() {
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorio(numeroLaboratorio);
		return to;
	}

	public void alterar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorio(numeroLaboratorio);
		dao.alterar(to);
	}

	public void consultar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = dao.consultar(id);
		nome = to.getNome();
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		vagas = to.getVagas();
		valor = to.getValor();
		softwares = to.getSoftwares();
		numeroLaboratorio = to.getNumeroLaboratorio();
	}

	public void deletar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setId(id);
		dao.deletar(to);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoInformatica other = (CursoInformatica) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (id != other.id) {
			return false;
		}
		return true;
	}


}