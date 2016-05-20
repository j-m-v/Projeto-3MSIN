package to;

public class CursoInformaticaTO {

	private int id;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private String horario;
	private int vagas;
	private double valor;
	private String softwares;
	private String numeroLaboratorio;

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

}
