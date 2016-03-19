package to;

public class MatriculaInformaticaTO {
	// atributos
	private int codigoMatricula;
	private int codigoAluno;
	private int codigoCurso;
	private String dataMatricula;
	private double valorMatricula;
	private String statusMatricula;
	private String statusPagamento;

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
}
