package to;

public class CursoInformaticaTO {

	private int codigoInformatica;
	private String nomeCurso;
	private String dataInicio;
	private String dataTermino;
	private String horarioPrevisto;
	private int numeroVagas;
	private double valorCurso;
	private String softwares;
	private String numeroLaboratorios;

	// MÉTODOS DE ACESSO
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

	// MÉTODOS MODIFICADORES
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

}
